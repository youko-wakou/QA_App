package jp.techacademy.wakou.youko.qa_app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class QuestionListActivity extends AppCompatActivity {
    public void favoAdd(String title,String message){
        new AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton("OK",null)
        .show();
    }

}
