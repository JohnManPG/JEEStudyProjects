package PO;

import java.io.Serializable;

public class Login implements Serializable {
        private Integer id;
        private String loginname;    //��¼�˺�
        private String loginpwd;     //��¼����
        private Company company;   //��������һ����Company 
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getLoginname() {
			return loginname;
		}
		public void setLoginname(String loginname) {
			this.loginname = loginname;
		}
		public String getLoginpwd() {
			return loginpwd;
		}
		public void setLoginpwd(String loginpwd) {
			this.loginpwd = loginpwd;
		}
		public Company getCompany() {
			return company;
		}
		public void setCompany(Company company) {
			this.company = company;
		}
        
}
