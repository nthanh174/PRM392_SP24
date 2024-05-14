package sl_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.code.R;

public class ptb2 extends AppCompatActivity {

    EditText txtA, txtB, txtC;
    Button btnCal;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ptb2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        txtC = findViewById(R.id.txtC);
        btnCal = findViewById(R.id.btnCal);
        txtResult = findViewById(R.id.txtResult);

        btnCal.setOnClickListener(v -> {
            double a = Double.parseDouble(txtA.getText().toString());
            double b = Double.parseDouble(txtB.getText().toString());
            double c = Double.parseDouble(txtC.getText().toString());
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                txtResult.setText("Phương trình có hai nghiệm: x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                txtResult.setText("Phương trình có nghiệm kép: x = " + x);
            } else {
                txtResult.setText("Phương trình vô nghiệm");
            }
        });
    }
}