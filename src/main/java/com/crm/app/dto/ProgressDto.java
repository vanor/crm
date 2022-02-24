package com.crm.app.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.crm.app.utils.StaticUtils;

public class ProgressDto {
	private int global = 0;
	private int stage1 = 0;
	private String stage1Validator;
	private int stage2Global = 0;
	private int stage2FirstPriority = 0;
	private String stage2FirstPriorityValidator;
	private int stage2SecondPriority = 0;
	private String stage2SecondPriorityValidator;
	private int stage2ThirdPriority = 0;
	private String stage2ThirdPriorityValidator;
	private int stage3 = 0;
	private String stage3Validator;
	private int stage4 = 0;
	private String stage4Validator;
	private String firstPriorityName;
	private String secondPriorityName;
	private String thirdPriorityName;
	
	public int getGlobal() {
		return global;
	}
	public void setGlobal(int global) {
		this.global = global;
	}
	public int getStage1() {
		return stage1;
	}
	public void setStage1(int stage1) {
		this.stage1 = stage1;
	}
	public String getStage1Validator() {
		return stage1Validator;
	}
	public void setStage1Validator(String stage1Validator) {
		this.stage1Validator = stage1Validator;
	}
	public int getStage2Global() {
		return stage2Global;
	}
	public void setStage2Global(int stage2Global) {
		this.stage2Global = stage2Global;
	}
	public int getStage2FirstPriority() {
		return stage2FirstPriority;
	}
	public void setStage2FirstPriority(int stage2FirstPriority) {
		this.stage2FirstPriority = stage2FirstPriority;
	}
	public String getStage2FirstPriorityValidator() {
		return stage2FirstPriorityValidator;
	}
	public void setStage2FirstPriorityValidator(String stage2FirstPriorityValidator) {
		this.stage2FirstPriorityValidator = stage2FirstPriorityValidator;
	}
	public int getStage2SecondPriority() {
		return stage2SecondPriority;
	}
	public void setStage2SecondPriority(int stage2SecondPriority) {
		this.stage2SecondPriority = stage2SecondPriority;
	}
	public String getStage2SecondPriorityValidator() {
		return stage2SecondPriorityValidator;
	}
	public void setStage2SecondPriorityValidator(String stage2SecondPriorityValidator) {
		this.stage2SecondPriorityValidator = stage2SecondPriorityValidator;
	}
	public int getStage2ThirdPriority() {
		return stage2ThirdPriority;
	}
	public void setStage2ThirdPriority(int stage2ThirdPriority) {
		this.stage2ThirdPriority = stage2ThirdPriority;
	}
	public String getStage2ThirdPriorityValidator() {
		return stage2ThirdPriorityValidator;
	}
	public void setStage2ThirdPriorityValidator(String stage2ThirdPriorityValidator) {
		this.stage2ThirdPriorityValidator = stage2ThirdPriorityValidator;
	}
	public int getStage3() {
		return stage3;
	}
	public void setStage3(int stage3) {
		this.stage3 = stage3;
	}
	public String getStage3Validator() {
		return stage3Validator;
	}
	public void setStage3Validator(String stage3Validator) {
		this.stage3Validator = stage3Validator;
	}
	public int getStage4() {
		return stage4;
	}
	public void setStage4(int stage4) {
		this.stage4 = stage4;
	}
	public String getStage4Validator() {
		return stage4Validator;
	}
	public void setStage4Validator(String stage4Validator) {
		this.stage4Validator = stage4Validator;
	}
	public String getFirstPriorityName() {
		return firstPriorityName;
	}
	public void setFirstPriorityName(String firstPriorityName) {
		this.firstPriorityName = firstPriorityName;
	}
	public String getSecondPriorityName() {
		return secondPriorityName;
	}
	public void setSecondPriorityName(String secondPriorityName) {
		this.secondPriorityName = secondPriorityName;
	}
	public String getThirdPriorityName() {
		return thirdPriorityName;
	}
	public void setThirdPriorityName(String thirdPriorityName) {
		this.thirdPriorityName = thirdPriorityName;
	}
	
	@Override
	public String toString() {
		return "ProgressDto [global=" + global + ", stage1=" + stage1 + ", stage1Validator=" + stage1Validator
				+ ", stage2Global=" + stage2Global + ", stage2FirstPriority=" + stage2FirstPriority
				+ ", stage2FirstPriorityValidator=" + stage2FirstPriorityValidator + ", stage2SecondPriority="
				+ stage2SecondPriority + ", stage2SecondPriorityValidator=" + stage2SecondPriorityValidator
				+ ", stage2ThirdPriority=" + stage2ThirdPriority + ", stage2ThirdPriorityValidator="
				+ stage2ThirdPriorityValidator + ", stage3=" + stage3 + ", stage3Validator=" + stage3Validator
				+ ", stage4=" + stage4 + ", stage4Validator=" + stage4Validator + ", firstPriorityName="
				+ firstPriorityName + ", secondPriorityName=" + secondPriorityName + ", thirdPriorityName="
				+ thirdPriorityName + "]";
	}
	
	public String getStage2Validators() {
		List<String> vs = List.of(stage2FirstPriorityValidator, stage2SecondPriorityValidator, stage2ThirdPriorityValidator);
		vs = StaticUtils.getUniqueValues(vs);
		
		return String.join(", ", vs);
	}
	
	public String getAllValidators() {
		List<String> vs = new ArrayList<>();
		vs.add(stage1Validator);
		vs.add(stage3Validator);
		vs.add(stage4Validator);
		List<String> stage2Vs = Arrays.asList(this.getStage2Validators().split(", "));
		vs.addAll(stage2Vs);
		vs = StaticUtils.getUniqueValues(vs);
		
		return String.join(", ", vs);
	}
}
