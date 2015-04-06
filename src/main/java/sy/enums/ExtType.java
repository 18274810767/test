package sy.enums;

import sy.annt.ExtBean2JsUtils;

public enum ExtType {


	selectfield{

		@Override
		public String getMoban() {
			// TODO Auto-generated method stub
			return "{xtype : 'selectfield',\r\n" + 
					"										name : '${name}',\r\n" + 
					"										label : '${label}',\r\n" + 
					"										store : '${store}'\r\n" + 
					"									${other}}";
		}
		
		
	}, textfield {
		@Override
		public String getMoban() {
			// TODO Auto-generated method stub
			return ExtBean2JsUtils.getFileType(ExtType.textfield);
		}
	}, passwordfield {
		@Override
		public String getMoban() {
			// TODO Auto-generated method stub
			 return ExtBean2JsUtils.getFileType(ExtType.passwordfield);
		}
	}, urlfield {
		@Override
		public String getMoban() {
			// TODO Auto-generated method stub
			 return ExtBean2JsUtils.getFileType(ExtType.urlfield);
		}
	}, emailfield {
		@Override
		public String getMoban() {
			// TODO Auto-generated method stub
			  return ExtBean2JsUtils.getFileType(ExtType.emailfield);
		}
	}, spinnerfield {
		@Override
		public String getMoban() {
			// TODO Auto-generated method stub
			return "{\r\n" + 
					"										xtype : 'spinnerfield',\r\n" + 
					"										name : '${name}',\r\n" + 
					"										label : '${label}',\r\n" + 
					"										minValue : ${minValue},\r\n" + 
					"										maxValue : ${maxValue},\r\n" + 
					"										stepValue : ${stepValue},\r\n" + 
					"										cycle : true\r\n" + 
					"									}";
		}
	}, checkboxfield {
		@Override
		public String getMoban() {
			// TODO Auto-generated method stub
			return "{\r\n" + 
					"										xtype : 'checkboxfield',\r\n" + 
					"										name : '${name}',\r\n" + 
					"										label : '${label}'\r\n" + 
					"									}";
		}
	}, datepickerfield {
		@Override
		public String getMoban() {
			// TODO Auto-generated method stub
			return "{\r\n" + 
					"										xtype : 'datepickerfield',\r\n" + 
					"										destroyPickerOnHide : true,\r\n" + 
					"										name : '${name}',\r\n" + 
					"										label : '${label}',\r\n" + 
					"										value : new Date(),\r\n" + 
					"										picker : {\r\n" + 
					"											yearFrom : 1990\r\n" + 
					"										}\r\n" + 
					"									}";
		}
	}, textareafield {
		@Override
		public String getMoban() {
			// TODO Auto-generated method stub
			return "{\r\n" + 
					"										xtype : 'textareafield',\r\n" + 
					"										name : '${name}',\r\n" + 
					"										label : '${label}'\r\n" + 
					"									}";
		}
	},hiddenfield {
		@Override
		public String getMoban() {
			// TODO Auto-generated method stub
			return "xtype: 'hiddenfield',\r\n" + 
					"                    name: '${name}',\r\n";
		}
	},checkboxgroup{

		@Override
		public String getMoban() {
			// TODO Auto-generated method stub
			return "{\r\n" + 
					"							xtype : 'fieldset',\r\n" + 
					"							title : '${label}',\r\n" + 
					"							closable:true,\r\n" + 
					"							defaults : {\r\n" + 
					"								labelWidth : '35%',\r\n" + 
					"										xtype : 'checkboxfield',\r\n" + 
					"								name:'${name}'\r\n" + 
					"							},\r\n" + 
					"							items : [\r\n" + 
					"							${json}\r\n" + 
					"							]}";
		}
		
	};
	public abstract  String getMoban();
}
