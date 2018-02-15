package com.view9.couriercustomer.ui.activities.splash;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.widget.Toast;

import com.view9.courierserviceapp.R;
import com.view9.courierserviceapp.ext.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import id.zelory.compressor.Compressor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by dell on 2/14/2018.
 */

public class CameraActivity extends Activity {

    public static  String type ;
    File tempOutputFile;
    private static int RESULT_LOAD_IMAGE1 = 1;
    Bitmap rotatedBMP, scaled;
    String picturePath1, picturePathG;
    static final int REQUEST_TAKE_PHOTO1 = 2;
    String selectedPath;
    File compressedImage;
    private File actualImage;
    File photoFile;
    SharedPreferences sharedPreferences;
    Random random = new Random(System.nanoTime());
    File pictureFile;
    ProgressDialog progressDialog ;
    public File finalfile;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signature_layout);

        if ( Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission( CameraActivity.this, Manifest.permission.CAMERA ) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission( CameraActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            dispatchTakePictureIntent(RESULT_LOAD_IMAGE1);
        }else
        {
            Toast.makeText(CameraActivity.this,"Please give permission manually",Toast.LENGTH_SHORT).show();
        }

    }

    private Uri getTempUri() {
        return Uri.fromFile(getTempFile());
    }

    private File getTempFile() {

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

            File file = new File(Environment.getExternalStorageDirectory(),"TEMP_PHOTO_FILE");
            try {
                file.createNewFile();
            } catch (IOException e) {

            }

            return file;
        } else {

            return null;
        }
    }

    private void dispatchTakePictureIntent(final int requestcode) {


        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String imageFileName = "Camera_" + timeStamp + "_";
            tempOutputFile = new File(CameraActivity.this.getExternalCacheDir(), imageFileName + ".jpeg");
            Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, FileProvider.getUriForFile(CameraActivity.this,
                    "com.view9.courierserviceapp.provider",
                    tempOutputFile));
            startActivityForResult(captureIntent, requestcode);
        } catch (Exception e) {
            Toast.makeText(CameraActivity.this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    private File getOutputMediaFile() {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.
        File storageDir =CameraActivity.this.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (!storageDir.exists()) {
            if (!storageDir.mkdirs()) {
                return null;
            }
        }
        // Create a media file name
        String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date());
        File mediaFile;
        String mImageName = "Gallery_" + timeStamp + random.nextInt(1000000000) + ".jpeg";
        mediaFile = new File(storageDir.getPath() + File.separator + mImageName);
        picturePathG = mediaFile.getAbsolutePath();
        return mediaFile;

    }

    private void storeImage(Bitmap image) {
        pictureFile = getOutputMediaFile();
        if (pictureFile == null) {
            Log.d("TAG",
                    "Error creating media file, check storage permissions: ");// e.getMessage());
            return;
        }
        try {
            FileOutputStream fos = new FileOutputStream(pictureFile);
            image.compress(Bitmap.CompressFormat.PNG, 90, fos);
            fos.close();
        } catch (FileNotFoundException e) {
            Log.d("TAG", "File not found: " + e.getMessage());
        } catch (IOException e) {
            Log.d("TAG", "Error accessing file: " + e.getMessage());
        }
    }


    @Override
    public void onActivityResult(final int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        //  Log.i(TAG, "onActivityResult: " + this);

        String TAG = "Tag";

        if (resultCode != CameraActivity.this.RESULT_OK) {
            return;
        }

      if (requestCode == REQUEST_TAKE_PHOTO1 ) {


            try{
                Uri outputFile;

                if (data != null && (data.getAction() == null || !data.getAction().equals(MediaStore.ACTION_IMAGE_CAPTURE))) {
                    outputFile = data.getData();
                    actualImage = new File(getPath(outputFile));

                } else {

                    actualImage = tempOutputFile;
//                actualImageView.setImageBitmap(BitmapFactory.decodeFile(actualImage.getAbsolutePath(),options));
                    // actualSizeTextView.setData(String.format("Size : %s", getReadableFileSize(actualImage.length())));
                }


                if (actualImage == null) {
                    Toast.makeText(CameraActivity.this,  "Please choose the image", Toast.LENGTH_LONG).show();
                } else {

                    compressedImage = new Compressor.Builder(CameraActivity.this)
                            .setMaxWidth(1024)
                            .setMaxHeight(720)
                            .setQuality(100)
                            .setCompressFormat(Bitmap.CompressFormat.JPEG)
                            .setDestinationDirectoryPath(CameraActivity.this.getExternalFilesDir(
                                    Environment.DIRECTORY_PICTURES).getAbsolutePath())
                            .build()
                            .compressToFile(actualImage);
                    setPic(requestCode, compressedImage.getAbsolutePath());
                }

                //UpdateUserProfile(compressedImage);
                uploadimageintoserver(compressedImage);

            }catch(Exception e){
                Toast.makeText(CameraActivity.this,"CompressedException:"+e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }

    }


    public String getPath(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = CameraActivity.this.getContentResolver().query(uri, projection, null, null, null);
        if (cursor == null) return null;
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String s = cursor.getString(column_index);
        cursor.close();
        return s;
    }


    private void setPic(int requestcode, String pathfile) {


        try {

            // Bitmap bitmap = BitmapFactory.decodeFile(picturePath, bmOptions);
            //Bitmap bitmap =  decodeSampledBitmapFromFile(picturePath,100,100);

            if (requestcode == 2) {
                picturePath1 = pathfile;
                sharedPreferences.edit().putString(Constants.PROFILEIMAGE, picturePath1).apply();

                // settingView.takeImage1.setImageBitmap(BitmapFactory.decodeFile(picturePath1));
                /*Glide.with(this).load(picturePath1)
                        .into(settingView.takeImage1);*/
            }


        } catch (OutOfMemoryError e) {
            Toast.makeText(CameraActivity.this, "OutOfMemoryException:"+e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


    public void uploadimageintoserver(File file) {

        finalfile =file;

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part userimage =
                MultipartBody.Part.createFormData("profile_picture", "image/jpeg", requestFile);

       /* if(AppUtils.hasInternet(getActivity())) {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Uploading picture please wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();
            ApiManager.UserProfileImageResponse(profileRespnseDtoCallback, settingView.preferencesManager.get(Constants.TOKEN), settingView.preferencesManager.get(Constants.COOKIE), userimage);
        }else
        {
            Toast.makeText(getActivity(), "Please check your network connection", Toast.LENGTH_LONG).show();
        }
*/
    }

}
