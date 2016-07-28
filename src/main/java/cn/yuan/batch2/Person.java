package cn.yuan.batch2;

public class Person {

	private Long personId;
	
	private String personName;
	
	private Integer personAge;
	
	private String personSex;

	public Person(){
		
	}
	public Person(String personName, Integer personAge, String personSex) {
		super();
		this.personName = personName;
		this.personAge = personAge;
		this.personSex = personSex;
	}
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Integer getPersonAge() {
		return personAge;
	}
	public void setPersonAge(Integer personAge) {
		this.personAge = personAge;
	}
	public String getPersonSex() {
		return personSex;
	}
	public void setPersonSex(String personSex) {
		this.personSex = personSex;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", personAge=" + personAge
				+ ", personSex=" + personSex + "]";
	}
	
}
