package com.example.win8.quotegenerator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class GenerateQuoteAtWood extends Activity {

    public Motivational mot;
    public Friendship friend;
    public Love love;
    public Inspirational insp;
    public Bitmap bm, newImage;
    int x=300,y=200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_image);

        ImageView mImageView = (ImageView)findViewById(R.id.imageView1);

        bm = BitmapFactory.decodeResource(getResources(), R.drawable.fix);


        Bitmap.Config config = bm.getConfig();
        int width = bm.getWidth();
        int height = bm.getHeight();

        newImage = Bitmap.createBitmap(width, height, config);

        Canvas c = new Canvas(newImage);
        c.drawBitmap(bm, 0, 0, null);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(Typeface.create(Typeface.SERIF, Typeface.ITALIC));
        paint.setTextSize(30);
        if (insp.chosen == true){
            for(String line: insp.child.split("\n")){
                c.drawText(line, x, y, paint);
                y += paint.descent() - paint.ascent();
            }
            c.drawText(" - " + insp.group, x, y, paint);
        }else if(friend.chosen == true){
            for(String line: friend.child.split("\n")){
                c.drawText(line, x, y, paint);
                y += paint.descent() - paint.ascent();
            }
            c.drawText(" - " + friend.group, x, y, paint);
        }else if(mot.chosen == true){
            for(String line: mot.child.split("\n")){
                c.drawText(line, x, y, paint);
                y += paint.descent() - paint.ascent();
            }
            c.drawText(" - " + mot.group, x, y, paint);;
        }else if(love.chosen == true){
            for(String line: love.child.split("\n")){
                c.drawText(line, x, y, paint);
                y += paint.descent() - paint.ascent();
            }
            c.drawText(" - " + love.group, x, y, paint);
        }

        mImageView.setImageBitmap(newImage);

    }

    public void save_onClick(View v) {
    /*
     * Save bitmap to MediaStore
     */

        //get bitmap from ImageVIew
        //not always valid, depends on your drawable
        ContentResolver cr = getContentResolver();
        String title = "myBitmap";
        String description = "My bitmap created by Android-er";
        String savedURL = MediaStore.Images.Media.insertImage(cr, newImage, title, description);

        new AlertDialog.Builder(GenerateQuoteAtWood.this).setTitle("Berhasil")
                .setMessage("Gambar berhasil disimpan. Jika gambar tidak muncul pada urutan pertama di Galeri, silahkan periksa di urutan paling terakhir.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                }).show();

    }
}