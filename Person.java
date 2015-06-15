import java.io.Serializable;



class Person{
	String personNO;
	String name;
	String age;
	String no;
	
	public String getPersonNO(){
		return personNO;
	}
	public String getName(){
		return name;
	}
	public String getAge(){
		return age;
	}
	public String getNo(){
		return no;
	}
	public void setAge(String age){
		this.age = age;
	}
	public void setNumber(String no) {
		this.no = no;
	}
	
	
}

class Student extends Person implements Serializable {
	String personNO;
	String name;
	String age;
	String no;
	String em; //이과 문과
	String group;
	String select_subject;
	public Student(String personNO, String name,String age, String em, String group, String select_subject){
		this.personNO = personNO;
		this.name = name;
		this.age = age;
		this.em = em;
		this.group = group;
		this.select_subject = select_subject;
	}
	public void setEM(String em) {
	        this.em = em;
	}
	public String getPersonNO(){
		return personNO;
	}
	public String getName(){
		return name;
	}
	public String getAge(){
		return age;
	}
	public String getNo(){
		return no;
	}
	public void setAge(String age){
		this.age = age;
	}
	public void setNumber(String no) {
		this.no = no;
	}
	public void setGroup(String group) {
	        this.group = group;
	}
	public String getSelect_subject() {
		// TODO Auto-generated method stub
		return select_subject;
	}
	
	public String getGroup() {
		// TODO Auto-generated method stub
		return group;
	}
	public String getEM() {
		// TODO Auto-generated method stub
		return em;
	}
	public String toString(){
		return getPersonNO()+ "," +getName() + "," + getAge() + "," + getEM() + "," + getGroup() + "," + getSelect_subject();
	}
}

class Teacher extends Person implements Serializable{
	String personNO;
	String name;
	String age;
	String no;
	String subject_name;
	String group;
	public Teacher(String personNO, String name, String age, String subject_name, String group, String no){
		this.personNO = personNO;
		this.name = name;
		this.age = age;
		this.subject_name = subject_name;
		this.group = group;
		this.no = no;
	}
	public String toString(){
		return getName() + "," + getAge() + "," + getSubject_Name() + "," + getGroup() + "," + getNo();
	}
	public void setGroup(String group) {
        this.group = group;
	}
	public void setSSubject_Name(String subject_name) {
        this.subject_name = subject_name;
	}
	public String getGroup() {
		// TODO Auto-generated method stub
		return group;
	}
	public String getSubject_Name() {
		// TODO Auto-generated method stub
		return subject_name;
	}
	public String getPersonNO(){
		return personNO;
	}
	public String getName(){
		return name;
	}
	public String getAge(){
		return age;
	}
	public String getNo(){
		return no;
	}
	public void setAge(String age){
		this.age = age;
	}
	public void setNumber(String no) {
		this.no = no;
	}
	
}