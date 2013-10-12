package com.myerscough.viennacitybike.tasks;

import com.myerscough.viennacitybike.handlers.ReportStatusHandler;

/**
 * 
 * @author Jason Myerscough
 *
 */
public class ViennaCityBikeXMLRunnable implements Runnable
{
	private static final String CLASS_TAG = "ViennaCityBikeXMLRunnable";
	private ReportStatusHandler handler;
	
	public ViennaCityBikeXMLRunnable(ReportStatusHandler handler)
	{
		this.handler = handler;
	}

	@Override
	public void run()
	{
		informStart();
		
		// download and parse the xml file
		
		informFinish();
	}
	
	private void informStart()
	{
		
	}
	
	private void informFinish()
	{
		
	}

}
