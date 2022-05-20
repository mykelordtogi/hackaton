package com.example.demo.enums;

public enum HazardPayInfoEnum {
	One(50),
	Two(100),
	Three(125),
	Four(150);
	
Integer value;

	
HazardPayInfoEnum(Integer value) {
        this.value = value;
    }

public int getValue() {
    return this.value;
 }
}

