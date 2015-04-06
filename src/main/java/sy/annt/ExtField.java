package sy.annt;

import java.util.Map;

public class ExtField<String,Ext> implements Map.Entry<String, Ext> {

	private String name;
	private Ext ext;
	
	public ExtField(String name,Ext ext){
		this.name=name;
		this.ext=ext;
		
	}
	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public Ext getValue() {
		// TODO Auto-generated method stub
		return this.ext;
	}

	@Override
	public Ext setValue(Ext value) {
		// TODO Auto-generated method stub
		this.ext=value;
				
		return this.ext;
	}

}
