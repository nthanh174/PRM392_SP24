package sl_2.bt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.code.R;

import sl_2.code.Activity_1;
import sl_2.code.Activity_2;

public class bt1 extends AppCompatActivity {

    EditText txt_1, txt_2;
    TextView txt_rs;
    Button btn_cal, btn_send;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bt1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txt_1 = findViewById(R.id.txt_1);
        txt_2 = findViewById(R.id.txt_2);
        txt_rs = findViewById(R.id.txt_rs);
        btn_cal = findViewById(R.id.btn_cal);
        btn_send = findViewById(R.id.btn_send);

        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_rs.setText(Sum().toString());
            }
        });
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bt1.this, bt2.class);
                intent.putExtra("RS", Sum());
                startActivity(intent);
            }
        });
    }
    Double Sum(){
        double a = Double.parseDouble(txt_1.getText().toString());
        double b = Double.parseDouble(txt_2.getText().toString());
        return a + b;
    }
}