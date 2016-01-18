package com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.test;

import com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.FormularioActivity;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class Test_Usuario1 extends ActivityInstrumentationTestCase2<FormularioActivity> {
  	private Solo solo;
  	
  	public Test_Usuario1() {
		super(FormularioActivity.class);
  	}

  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
  	}
  
	public void testRun() {
        //Take screenshot
        solo.takeScreenshot();
        //Wait for activity: 'com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.FormularioActivity'
		solo.waitForActivity(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.FormularioActivity.class, 2000);
        //Enter the text: 'Fernando'
		solo.clearEditText((android.widget.EditText) solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.editText));
		solo.enterText((android.widget.EditText) solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.editText), "Fernando");
        //Enter the text: 'Lpez'
		solo.clearEditText((android.widget.EditText) solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.editText2));
		solo.enterText((android.widget.EditText) solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.editText2), "Lpez");
        //Click on Lpez
		solo.clickOnView(solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.editText2));
        //Click on Empty Text View
		solo.clickOnView(solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.editText3));
        //Enter the text: 'Capitan'
		solo.clearEditText((android.widget.EditText) solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.editText3));
		solo.enterText((android.widget.EditText) solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.editText3), "Capitan");
        //Click on Lpez
		solo.clickOnView(solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.editText2));
        //Enter the text: 'Lopez'
		solo.clearEditText((android.widget.EditText) solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.editText2));
		solo.enterText((android.widget.EditText) solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.editText2), "Lopez");
        //Click on Empty Text View
		solo.clickOnView(solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.editText4));
        //Enter the text: '45805327E'
		solo.clearEditText((android.widget.EditText) solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.editText4));
		solo.enterText((android.widget.EditText) solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.editText4), "45805327E");
        //Click on Sí
		solo.clickOnView(solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.checkBox));
        //Click on Sí
		solo.clickOnView(solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.checkBox));
        //Click on Sí
		solo.clickOnView(solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.checkBox));
        //Click on Sí
		solo.clickOnView(solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.checkBox));
        //Click on Enviar
		solo.clickOnView(solo.getView(com.salesianostriana.dam.di.ejercicio01_aplicacionandalucia.R.id.button));
	}
}
