package android.curso.cronometro;
import android.R;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean execucao = false;
    private int segundo = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
    }

    public void onClickStart(View view) {
        execucao = true;
    }



    public void onClickStop(View view) {
        execucao = false;
    }

    public void onClickReset(View view) {
        execucao = false;
        segundo = 0;

    }
    private void runTimer () {
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {

            public void run() {
                int hours = segundo / 3600;
                int minutes = (segundo % 3600) / 60;
                int secs = segundo % 60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);

                timeView.setText(time);
                if (execucao) {
                    segundo++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}
