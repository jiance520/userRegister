package com.entity;

public class Register {
    private Integer usidint;

    private String uname;

    private String upwd;

    private Byte sex;

    private String cardNo;

    private String email;

    private Long mobile;

    public Integer getUsidint() {
        return usidint;
    }
    
    public Register(Integer usidint, String uname, String upwd, Byte sex,
			String cardNo, String email, Long mobile) {
		super();
		this.usidint = usidint;
		this.uname = uname;
		this.upwd = upwd;
		this.sex = sex;
		this.cardNo = cardNo;
		this.email = email;
		this.mobile = mobile;
	}
    
	public Register() {
		super();
	}

	public void setUsidint(Integer usidint) {
        this.usidint = usidint;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd == null ? null : upwd.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

	@Override
	public String toString() {
		return "Register [usidint=" + usidint + ", uname=" + uname + ", upwd="
				+ upwd + ", sex=" + sex + ", cardNo=" + cardNo + ", email="
				+ email + ", mobile=" + mobile + "]";
	}
    
}