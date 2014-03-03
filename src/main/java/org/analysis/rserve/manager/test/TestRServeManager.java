package org.analysis.rserve.manager.test;

import java.util.ArrayList;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;



public class TestRServeManager {



	public String testRServe() throws RserveException, REXPMismatchException{
		ArrayList<String> s = new ArrayList<String>();
		RConnection c = new RConnection();
		try{

			REXP x = c.eval("R.version.string");
			System.out.println(x.asString());

			double[] d= c.eval("rnorm(100)").asDoubles();

			for(Double v:d){
				System.out.println(v.doubleValue());
				s.add(String.valueOf(v.doubleValue()));


			}
		}catch(REXPMismatchException e){

		}finally{
			c.close();
		}
		return s.toString();


	}
}
