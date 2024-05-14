package sl_3;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.code.R;

public class list_view extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView=findViewById(R.id.listView);

        String[] data = new String[]{
                "Android Development Fundamentals",
                "iOS App Development with Swift",
                "Python Programming Basics",
                "Machine Learning Essentials",
                "Web Development with React"
        };
        ArrayAdapter<String> adapter=new ArrayAdapter<>(list_view.this,
                android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
    }
}