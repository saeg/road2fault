package br.usp.each.saeg.road2fault;

import java.util.ArrayList;
import java.util.List;
import br.usp.each.inss.cache.MethodCallPairRequirements;
import br.usp.each.opal.requirement.MethodCallPair;

public class MethodCallPairRequirementWrapper {

	private static List<MethodCallPair> methodCallRequirement;
	
	public MethodCallPairRequirementWrapper(){
		methodCallRequirement = new ArrayList<MethodCallPair>();
	}
	
	public static void load(MethodCallPairRequirements requirements, MethodCallPairRequirementWrapper wrapper) {
        for (MethodCallPair entry : requirements.getRequirements()) {
        	//System.out.println("Requirements : "+entry.toString());
        	wrapper.add(entry);
        }
        //System.out.println("Requirements  size: "+wrapper.getRequirements().size());
    }
	
	public void add(MethodCallPair mcp)
	{
		methodCallRequirement.add(mcp);
	}
	
	public List<MethodCallPair> getRequirements()
	{
		return methodCallRequirement;
	}
	
}

