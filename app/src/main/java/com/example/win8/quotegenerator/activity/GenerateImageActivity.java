package com.example.win8.quotegenerator.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

import com.example.win8.quotegenerator.R;

public class GenerateImageActivity extends Activity {
    public static final String EXTRA_QUOTE = "extra_quote";
    public static final String EXTRA_PERSON = "extra_person";
    public static final String EXTRA_IMG_ID = "extra_img_id";
    public Bitmap newImage;
//    int x=300,y=200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_image);

        ImageView mImageView = (ImageView)findViewById(R.id.imageView1);

        int img_id = getIntent().getIntExtra(EXTRA_IMG_ID, R.drawable.temp_14);
        String person = getIntent().getStringExtra(EXTRA_PERSON);
        String quote = getIntent().getStringExtra(EXTRA_QUOTE);

        drawQuote(mImageView, img_id, person, quote);

    }

    private void drawQuote(ImageView mImageView, int img_id, String person, String quote){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;
//        int screenHeight = size.y;

        Bitmap bm = BitmapFactory.decodeResource(getResources(), img_id);

//        Bitmap.Config config = bm.getConfig();
        int width = bm.getWidth();
        int height = bm.getHeight();

        newImage = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Canvas c = new Canvas(newImage);
        c.drawBitmap(bm, 0, 0, null);

        Paint paint = new Paint();
        paint.setColor(adjustColor(img_id));
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(40);
        paint.setTypeface(Typeface.create(Typeface.SERIF, Typeface.ITALIC));

//        int x = (newImage.getWidth()/2) - bound.centerX();
        int x = getApproxXToCenterText(paint, screenWidth);
        int y = (c.getHeight()/2) - 200;

        for(String line: quote.split("\n")){
            c.drawText(line, x, y, paint);
            y += paint.descent() - paint.ascent();
        }

        c.drawText(" - " + person, x, y, paint);

        mImageView.setImageBitmap(newImage);
    }

    private int getApproxXToCenterText(Paint p, int widthToFit){
        float defaultTextWidth = 200;
        return (int) ((widthToFit-defaultTextWidth)/2f) - (int)(p.getTextSize()/2f);
    }

    private int adjustColor(int img_id){
        int color = 0;
        switch (img_id){
            case R.drawable.temp_14:
                color = Color.WHITE;
                break;
            case R.drawable.temp_4:
                color = Color.DKGRAY;
                break;
            case R.drawable.fix_1:
                color = Color.DKGRAY;
                break;
            case R.drawable.fix:
                color = Color.BLACK;
                break;
        }

        return color;
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

        new AlertDialog.Builder(GenerateImageActivity.this).setTitle("Berhasil")
                .setMessage("Gambar berhasil disimpan. Jika gambar tidak muncul pada urutan pertama di Galeri, silahkan periksa di urutan paling terakhir.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                }).show();
    }
}
