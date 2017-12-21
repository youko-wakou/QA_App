package jp.techacademy.wakou.youko.qa_app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionListActivity extends AppCompatActivity {
    private Button mfavo_b;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_questions);
        mfavo_b = findViewById(R.id.favobt);
        mfavo_b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("test", "テスト実行");
            }
        });
    }
    public class QuestionsListAdapter extends BaseAdapter {
        private LayoutInflater mLayoutInflater = null;
        private ArrayList<Question>mQuestionArrayList;
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
     }
}



