package com.javatishengzhilu.init.wx;

/**
 * 目录
 */
public class Menu {
	
	/**
	 * 菜单按钮
	 */
	private Button[] button;

	public Button[] getButton() {
		return button;
	}


	public void setButton(Button[] button) {
		this.button = button;
	}


	public Menu(Button[] button) {
		super();
		this.button = button;
	}


	public Menu() {
		super();
	}  
}
