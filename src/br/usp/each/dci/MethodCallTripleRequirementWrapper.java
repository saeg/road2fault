package br.usp.each.dci;

import java.util.ArrayList;
import java.util.List;
import br.usp.each.inss.cache.MethodCallTripleRequirements;
import br.usp.each.opal.requirement.MethodCallTriple;

public class MethodCallTripleRequirementWrapper {

	private static List<MethodCallTriple> methodCallRequirement;
	
	public MethodCallTripleRequirementWrapper(){
		methodCallRequirement = new ArrayList<MethodCallTriple>();
	}
	
	public static void load(MethodCallTripleRequirements requirements, MethodCallTripleRequirementWrapper wrapper) {
        for (MethodCallTriple entry : requirements.getRequirements()) {
        	//System.out.println("Requirements : "+entry.toString());
        	wrapper.add(entry);
        }
        //System.out.println("Requirements  size: "+wrapper.getRequirements().size());
    }
	
	public void add(MethodCallTriple mct)
	{
		methodCallRequirement.add(mct);
	}
	
	public List<MethodCallTriple> getRequirements()
	{
		return methodCallRequirement;
	}
}
