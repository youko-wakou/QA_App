package jp.techacademy.wakou.youko.qa_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
public class QuestionsListAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater = null;
    private ArrayList<Question>mQuestionArrayList;
    public Button mfavo_b;
    private void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mfavo_b = findViewById(R.id.favobt);
        mfavo_b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });

    }


    public QuestionsListAdapter(Context context){
        mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount(){
        return mQuestionArrayList.size();
    }
    @Override
    public Object getItem(int position){
        return mQuestionArrayList.get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.list_questions,parent,false);
        }
        TextView titleText = (TextView) convertView.findViewById(R.id.titleTextView);
        titleText.setText(mQuestionArrayList.get(position).getTitle());

        TextView nameText = (TextView)convertView.findViewById(R.id.nameTextView);
        nameText.setText(mQuestionArrayList.get(position).getName());

        TextView resText = (TextView) convertView.findViewById(R.id.resTextView);
        int resNum = mQuestionArrayList.get(position).getAnswers().size();
        resText.setText(String.valueOf(resNum));

        byte[]bytes = mQuestionArrayList.get(position).getImageBytes();
        if(bytes.length != 0){
            Bitmap image = BitmapFactory.decodeByteArray(bytes,0,bytes.length).copy(Bitmap.Config.ARGB_8888,true);
            ImageView imageView = (ImageView)convertView.findViewById(R.id.imageView);
            imageView.setImageBitmap(image);
        }
        return convertView;
    }
    public void setQuestionArrayList(ArrayList<Question> questionArrayList){
        mQuestionArrayList = questionArrayList;
    }


}
