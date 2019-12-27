package xyz.gabrielrohez.viewmodel.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.gabrielrohez.viewmodel.R;
import xyz.gabrielrohez.viewmodel.util.User;
import xyz.gabrielrohez.viewmodel.viewmodel.UserViewModel;

public class UserViewModelActivity extends AppCompatActivity {

    @BindView(R.id.etNombre)
    EditText etNombre;
    @BindView(R.id.etEdad)
    EditText etEdad;
    @BindView(R.id.tvUserInfo)
    TextView tvUserInfo;
    @BindView(R.id.tvUserViewModel)
    TextView tvUserViewModel;

    private List<User> userLis;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view_model);
        ButterKnife.bind(this);
        setUpView();
    }

    private void setUpView() {
        userLis = new ArrayList<>();
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
    }

    @OnClick({R.id.btnSalvar, R.id.btnMostrar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnSalvar:
                User user = new User();
                user.setNombre(etNombre.getText().toString().trim());
                user.setEdad(etEdad.getText().toString().trim());
                userLis.add(user);
                userViewModel.addUser(user);
                break;
            case R.id.btnMostrar:
                String texto = "";
                for (int i = 0; i < userLis.size(); i++) {
                    texto += userLis.get(i).getNombre() + " " + userLis.get(i).getEdad() + "\n";
                }
                tvUserInfo.setText(texto);

                texto = "";
                for (User userOne : userViewModel.getUserList()) {
                    texto += userOne.getNombre() + " " + userOne.getEdad() + "\n";
                }
                tvUserViewModel.setText(texto);
                break;
        }
    }
}
