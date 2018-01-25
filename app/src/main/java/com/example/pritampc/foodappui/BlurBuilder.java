package com.example.pritampc.foodappui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;
import android.view.View;

/**
 * Created by pritamPC on 1/22/2018.
 */

public class BlurBuilder {

    private static final float BITMAP_SCALE=0.6f;
    private static final float BITMAP_RADUIS=25f;

    public static Bitmap blur(Context context,Bitmap image)
    {
        int width=Math.round(image.getWidth()*BITMAP_SCALE);
        int height=Math.round(image.getHeight()*BITMAP_SCALE);

        Bitmap input_bmp=Bitmap.createScaledBitmap(image,width,height,false);
        Bitmap output_bmp=Bitmap.createBitmap(input_bmp);

        RenderScript rs=RenderScript.create(context);
        ScriptIntrinsicBlur intrinsicBlur=ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        Allocation tmpin=Allocation.createFromBitmap(rs,input_bmp);
        Allocation tmpout=Allocation.createFromBitmap(rs,output_bmp);

        intrinsicBlur.setRadius(BITMAP_RADUIS);
        intrinsicBlur.setInput(tmpin);
        intrinsicBlur.forEach(tmpout);
        tmpout.copyTo(output_bmp);

        return  output_bmp;
    }

}
