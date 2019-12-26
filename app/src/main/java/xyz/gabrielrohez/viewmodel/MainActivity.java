package xyz.gabrielrohez.viewmodel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnSumar, R.id.btnUser, R.id.btnLiveData, R.id.btnDataBinding, R.id.btnDataLive})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnSumar:
                startActivity(new Intent(getApplicationContext(), ViewModelActivity.class));
                break;
            case R.id.btnUser:
                //startActivity(new Intent(getApplicationContext(), UserViewModelActivity.class));
                break;
            case R.id.btnLiveData:
                //startActivity(new Intent(getApplicationContext(), LiveDataActivity.class));
                break;
            case R.id.btnDataBinding:
                //startActivity(new Intent(getApplicationContext(), DataBindingActivity.class));
                break;
            case R.id.btnDataLive:
                //startActivity(new Intent(getApplicationContext(), DBLDActivity.class));
                break;
        }
    }
}
