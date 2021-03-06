package com.example.learn.tool;

import com.example.learn.R;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MyDialog {
private Context context;
private NiftyDialogBuilder dialogBuilder;
private String titleColor;
private String dividerColor;
private String messageColor;
private String dialogColor;
	public MyDialog() {
		Log.i("MyDialog", "MyDialog");
	}
	public void cancel(){
		dialogBuilder.dismiss();
	}
	
	private void getColor(){
		switch (0) {
		case 0:
			titleColor="#000000";
			dividerColor="#FFFFFF";
			messageColor="#F0FFFF";
			dialogColor="#FFFFFF";
			break;
		case 1:
			titleColor="#FFFFFF";
			dividerColor="#FFA500";
			messageColor="#F0FFFF";
			dialogColor="#FFA500";
			break;
		default:
			titleColor="#FFFFFF";
			dividerColor="#ff33b5e5";
			messageColor="#F0FFFF";
			dialogColor="#ff33b5e5";
			break;
		}
	}
	/**
	 * @param i 弹出样式
	 * @param context 
	 * @param view 填充的view
	 * @param listener1 确认回调
	 * @param listener2	取消回调
	 */
	public void dialogShow(int i,Context context,View view,View.OnClickListener listener1,View.OnClickListener listener2){
		Log.i("MyDialog", "dialogShow");
		this.context=context;
        dialogBuilder= NiftyDialogBuilder.getInstance(context);
        
        String button1;
        String button2;
        getColor();
        Effectstype effect;
        
//        String page=context.getString(param);
        button1="确定";
        button2="取消";
        switch (i){
            case 1:effect=Effectstype.Fadein;break;//fadein
            case 2:effect=Effectstype.Slideright;break;//slideright
            case 3:effect=Effectstype.Slideleft;break;//slideleft
            case 4:effect=Effectstype.Slidetop;break;//slidetop
            case 5:effect=Effectstype.SlideBottom;break;//slideBottom
            case 6:effect=Effectstype.Newspager;break;//newspager
            case 7:effect=Effectstype.Fall;break;//fall
            case 8:effect=Effectstype.Sidefill;break;//sidefall
            case 9:effect=Effectstype.Fliph;break;//fliph
            case 10:effect=Effectstype.Flipv;break;//flipv
            case 11:effect=Effectstype.RotateBottom;break;//rotatebottom
            case 12:effect=Effectstype.RotateLeft;break;//rotateleft
            case 13:effect=Effectstype.Slit;break;//slit
            case 14:effect=Effectstype.Shake;break;//shake
            default :effect=Effectstype.Slit; break;
        }

        dialogBuilder
                .withTitle(context.getString(R.string.app_name))                               //.withTitle(null)  no title
                .withTitleColor(titleColor)                                  //def
                .withDividerColor(dividerColor)  
                .withMessage(null)                     					//.withMessage(null)  no Msg
                .withMessageColor(messageColor)                              //def  | withMessageColor(int resid)
                .withDialogColor(dialogColor)                               //def  | withDialogColor(int resid)                               //def
                .withIcon(context.getResources().getDrawable(R.drawable.my_launcher))
                .isCancelableOnTouchOutside(false)                           //def    | isCancelable(true)
                .withDuration(700)                                          //def
                .withEffect(effect)                                         //def Effectstype.Slidetop
                .withButton1Text(button1)                                      //def gone
                .withButton2Text(button2)                              //def gone
                .setCustomView(view,context)         //.setCustomView(View or ResId,context)
                .setButton1Click(listener1)
                .setButton2Click(listener2)
                .show();

    }
	

	
	

	
}
