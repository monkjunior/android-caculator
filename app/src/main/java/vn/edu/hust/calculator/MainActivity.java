package vn.edu.hust.calculator;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    EditText editText;

    int state;  // trang thai 1: nhap op1, 2: nhap op2
    int op1, op2;   // 2 toan hang
    int op;     // toan tu, 1: add, 2: sub, 3: mul, 4: div

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Typeface tf = Typeface.createFromAsset(getAssets(), "DS-DIGI.TTF");
        textView.setTypeface(tf);

        state = 1;
        op1 = 0;
        op2 = 0;
        op = 0;

        textView.setText(String.valueOf(op1));

        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);

        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnSub).setOnClickListener(this);
        findViewById(R.id.btnMul).setOnClickListener(this);
        findViewById(R.id.btnDiv).setOnClickListener(this);
        findViewById(R.id.btnEqual).setOnClickListener(this);

        findViewById(R.id.btnCE).setOnClickListener(this);
        findViewById(R.id.btnC).setOnClickListener(this);
        findViewById(R.id.btnBS).setOnClickListener(this);
        findViewById(R.id.btnInv).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn0) {
            addValue(0);
        } else if (id == R.id.btn1) {
            addValue(1);
        } else if (id == R.id.btn2) {
            addValue(2);
        } else if (id == R.id.btn3) {
            addValue(3);
        } else if (id == R.id.btn4) {
            addValue(4);
        } else if (id == R.id.btn5) {
            addValue(5);
        } else if (id == R.id.btn6) {
            addValue(6);
        } else if (id == R.id.btn7) {
            addValue(7);
        } else if (id == R.id.btn8) {
            addValue(8);
        } else if (id == R.id.btn9) {
            addValue(9);
        } else if (id == R.id.btnAdd) {
            changeState(1);
        }  else if (id == R.id.btnSub) {
            changeState(2);
        } else if (id == R.id.btnMul) {
            changeState(3);
        }  else if (id == R.id.btnDiv) {
            changeState(4);
        } else if (id == R.id.btnEqual) {
            calculateResult();
        } else if (id == R.id.btnCE) {
            // Xoa toan hang hien tai
            clearOperand();
        }  else if (id == R.id.btnC) {
            // Xoa phep tinh
            clearOperator();
        } else if (id == R.id.btnBS) {
            // Xoa chu so hang don vi
            removeDigit();
        } else if (id == R.id.btnInv) {
            inverseOperand();
        }
    }

    private void inverseOperand() {
        if (state == 1) {
            op1 = -op1;
            textView.setText(String.valueOf(op1));
        } else {
            op2 = -op2;
            textView.setText(String.valueOf(op2));
        }
    }

    private void removeDigit() {
        if (state == 1) {
            op1 = op1 / 10;
            textView.setText(String.valueOf(op1));
        } else {
            op2 = op2 / 10;
            textView.setText(String.valueOf(op2));
        }
    }

    private void clearOperand() {
        if (state == 1)
            op1 = 0;
        else
            op2 = 0;

        textView.setText("0");
    }

    private void clearOperator() {
        state = 1;
        op1 = 0;
        op2 = 0;
        textView.setText("0");
    }

    private void calculateResult() {
        int result;
        if (op == 1)
            result = op1 + op2;
        else if (op == 2)
            result = op1 - op2;
        else if (op == 3)
            result = op1 * op2;
        else
            result = op1 / op2;

        textView.setText(String.valueOf(result));

        state = 1;
        op1 = 0;
        op2 = 0;
    }

    private void changeState(int selectedOP) {
        op = selectedOP;
        state = 2;
        textView.setText(String.valueOf(op2));
    }

    private void addValue(int value) {
        if (state == 1) {
            op1 = op1 * 10 + value;
            textView.setText(String.valueOf(op1));
        } else {
            op2 = op2 * 10 + value;
            textView.setText(String.valueOf(op2));
        }
    }
}
