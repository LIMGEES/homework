package Generate;

public class G_Member {

    private String m_id;
    private String m_phone;
    private String m_name;
    private String m_pw;

    public G_Member(String m_phone,String m_pw,String m_name,String m_id) {
    	this.m_phone=m_phone;
    	this.m_pw=m_pw;		
		this.m_name=m_name;
		this.m_id=m_id;
	}
    public String getM_id() {
        return m_id;
    }


    public String getM_pw() {
        return m_pw;
    }


    public void setM_pw(String m_pw) {
        this.m_pw = m_pw;
    }


    public void setM_id(String m_id) {
        this.m_id = m_id;
    }


    public String getM_phone() {
        return m_phone;
    }


    public void setM_phone(String m_phone) {
        this.m_phone = m_phone;
    }


    public String getM_name() {
        return m_name;
    }


    public void setM_name(String m_name) {
        this.m_name = m_name;
    }


}
