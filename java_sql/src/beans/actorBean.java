package beans;

import java.util.ArrayList;

import helpers.jsonHelper;
import helpers.keyvaluepair;

public class actorBean {
	private int _id;
	private String _name;
	private String _hometown;
	private int _age;
	private int _addressId;
	

	public int getId() {
		return _id;
	}

	public void setId(int _id) {
		this._id = _id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String _name) {
		this._name = _name;
	}
	
	public String getHometown() {
		return _hometown;
	}

	public void setHometown(String _hometown) {
		this._hometown = _hometown;
	}

	public int getAge() {
		return _age;
	}

	public void setAge(int _age) {
		this._age = _age;
	}

	public int getAddressId() {
		return _addressId;
	}

	public void setAddressId(int _addressId) {
		this._addressId = _addressId;
	}
	
	public String toString() {
		String pattern = "Name = %s, Age = %d, Hometown = %s";
		String returnString = String.format(pattern, this._name, this._age, this._hometown);
		
		return returnString;
	}
	
	public String toJson() {
		ArrayList<keyvaluepair> dataList = new ArrayList<keyvaluepair>();
		dataList.add(new keyvaluepair("Name", this._name));
		dataList.add(new keyvaluepair("Age", Integer.toString(this._age)));
		dataList.add(new keyvaluepair("City", this._hometown));
		
		return jsonHelper.toJsonObject(dataList);
	}
	
}