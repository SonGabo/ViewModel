package xyz.gabrielrohez.viewmodel;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.gabrielrohez.viewmodel.util.Sumar;
import xyz.gabrielrohez.viewmodel.viewmodel.SumarViewModel;

public class ViewModelActivity extends AppCompatActivity {

    @BindView(R.id.tvSumar)
    TextView tvSumar;
    @BindView(R.id.tvSumarViewModel)
    TextView tvSumarViewModel;

    private int resultado;
    private SumarViewModel sumarViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);
        ButterKnife.bind(this);
        setUpView();
    }

    //  se intancia el viewmodel mediante el viewmodelprovider
    private void setUpView() {
        sumarViewModel = ViewModelProviders.of(this).get(SumarViewModel.class); //  se le pasa la clase ViewModel a la que se hace referencia
    }

    @OnClick(R.id.btnSumar)
    public void onViewClicked() {
        resultado = Sumar.sumar(resultado);
        tvSumar.setText(""+ resultado);

        sumarViewModel.setResultado(Sumar.sumar(sumarViewModel.getResultado()));
        tvSumarViewModel.setText(""+sumarViewModel.getResultado());
    }
}
