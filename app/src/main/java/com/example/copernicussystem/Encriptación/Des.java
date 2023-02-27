package com.example.copernicussystem.Encriptación;

import android.util.Log;

import java.io.Serializable;

public class Des implements Serializable {

    public static final String TAG = "MyPaginaWeb";
    public static final String KEY = "+4xij6jQRSBdCymMxweza/uMYo+o0EUg";

    public static String cifrar(String testClaro) {
        String testCifrado = null;

        MyDesUtil myDesUtil = new MyDesUtil( );

        if( isNotNullAndNotEmpty( KEY ) )
        {
            myDesUtil.addStringKeyBase64( KEY );
        }

        Log.i( TAG , testClaro);

        testCifrado = myDesUtil.cifrar( testClaro );
        Log.i( TAG , testCifrado );

        return testCifrado;
    }

    public static String desCifrar(String testCifrado) {
        String testDesCifrado = null;

        MyDesUtil myDesUtil = new MyDesUtil( );

        if( isNotNullAndNotEmpty( KEY ) )
        {
            myDesUtil.addStringKeyBase64( KEY );
        }
        Log.i( TAG , testCifrado);

        testDesCifrado = myDesUtil.desCifrar( testCifrado );
        Log.i( TAG, testDesCifrado );

        return testDesCifrado;
    }

    public static boolean isNotNullAndNotEmpty( String aux )
    {
        return aux != null && aux.length() > 0;
    }
}
