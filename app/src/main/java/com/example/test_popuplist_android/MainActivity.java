package com.example.test_popuplist_android;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean click = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final Button btn = (Button) findViewById(R.id.btnLista);
        @SuppressLint("ResourceType") final View view = inflater.inflate(R.layout.popuplist, (ViewGroup) findViewById(R.layout.activity_main));
        final PopupWindow pw = new PopupWindow(view);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click) {
                    pw.showAtLocation(v, Gravity.NO_GRAVITY, v.getLeft(), v.getBottom());
                    pw.update(v.getLeft(), v.getBottom() + 115, 400, 200);
                    ListView lst = (ListView) view.findViewById(R.id.lstView);
                    PopUpListAdapter adapter = new PopUpListAdapter(getApplicationContext());
                    lst.setAdapter(adapter);
                    lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(getApplicationContext(), adapter.getItem(position).toString(), Toast.LENGTH_SHORT).show();
                            btn.setText(adapter.getItem(position).toString());
                            pw.dismiss();
                            click = true;
                        }
                    });
                    click = false;
                } else {
                    pw.dismiss();
                    click = true;
                }
            }
        });
    }
}
