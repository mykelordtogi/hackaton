package com.example.demo.model;

public class Total {

//	public static void main(String[] args) {
//	
//		Employee bonus = new Employee();
//		
//		Integer twd = 30;
//		Integer sumOfDays = 20;
//		
//		Integer pab = bonus.getBonusInfo().getBonusPerMonth() / twd*(sumOfDays) ;
//		
//		
//
//	}
	
	Employee bonus = new Employee();
	
	  public int twd = 30;
	  public int sumOfDays = 20;
	  public int total = 1000/twd*(sumOfDays); 
	  
	  
	  public int areaA = 50;
	  public int areaB = 100;
	  public int areaC = 125;
	  public int areaD = 150;
	  
	  public int hazrdPay = areaA * sumOfDays;
	   
	    
	    public Employee getBonus() {
		return bonus;
	}



	public void setBonus(Employee bonus) {
		this.bonus = bonus;
	}



	public int getTwd() {
		return twd;
	}



	public void setTwd(int twd) {
		this.twd = twd;
	}



	public int getSumOfDays() {
		return sumOfDays;
	}



	public void setSumOfDays(int sumOfDays) {
		this.sumOfDays = sumOfDays;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	public int getAreaA() {
		return areaA;
	}



	public void setAreaA(int areaA) {
		this.areaA = areaA;
	}



	public int getAreaB() {
		return areaB;
	}



	public void setAreaB(int areaB) {
		this.areaB = areaB;
	}



	public int getAreaC() {
		return areaC;
	}



	public void setAreaC(int areaC) {
		this.areaC = areaC;
	}



	public int getAreaD() {
		return areaD;
	}



	public void setAreaD(int areaD) {
		this.areaD = areaD;
	}



	public int getHazrdPay() {
		return hazrdPay;
	}



	public void setHazrdPay(int hazrdPay) {
		this.hazrdPay = hazrdPay;
	}



	
}
