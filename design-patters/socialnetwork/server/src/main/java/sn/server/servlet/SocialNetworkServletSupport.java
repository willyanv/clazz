package sn.server.servlet;


import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xingu.codec.Codec;
import xingu.container.Container;
import xingu.container.ContainerUtils;
import xingu.container.Inject;

public abstract class SocialNetworkServletSupport
	extends HttpServlet
{
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject("api")
	protected Codec codec;

	private boolean debugCors = false;
	
    @Override
    public void init(ServletConfig config) 
        throws ServletException
    {
        try
        {
            Container container = ContainerUtils.getContainer();
            container.startLifecycle(this, null);
        }
        catch (Exception e)
        {
            throw new ServletException("Error initializing service", e);
        }
        super.init(config);
    }

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse response)
		throws ServletException, IOException
	{
		/*
		 * CORS preflight
		 * See: http://www.html5rocks.com/en/tutorials/cors/
		 */
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "HEAD, OPTIONS, GET, POST, PUT, DELETE");
		response.addHeader("Access-Control-Allow-Headers", "X-Crossover-Auth-Token");

		super.doOptions(req, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
	{
		doProcess(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
	{
		doProcess(req, res);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, java.io.IOException 
	{
		if(debugCors)
		{
			/* Print Header Names for CORS Debugging */
			Enumeration names = request.getHeaderNames();
			while(names.hasMoreElements())
			{
				String name = (String) names.nextElement();
				System.out.println(name);
			}
		}

		response.addHeader("Access-Control-Allow-Origin", "*");
		Object result = null;
		try
		{
			result = process(request, response);
		}
		catch(Throwable t)
		{
			logger.error("Processing Error", t);
			String trace = ExceptionUtils.getStackTrace(t);
			result = new SystemError(t.getMessage(), trace);
		}
		finally
		{
			response.addHeader("Content-Type:", "application/json; charset=utf-8");
			if(result != null)
			{
				ServletOutputStream os = null;
				try
				{
					os = response.getOutputStream();
					String text = codec.encode(result);
					IOUtils.write(text, os);
				}
				catch(Exception e)
				{
					logger.error("Encoding Error", e);
					response.addHeader("Content-Type:", "text/plain; charset=utf-8");
					response.sendError(500, "Encoding error: " + e.getMessage());
				}
				finally
				{
					if(os != null)
					{
						os.close();
					}
				}
			}
		}
	}

	protected abstract Object process(HttpServletRequest request, HttpServletResponse response)
		throws Exception;
}