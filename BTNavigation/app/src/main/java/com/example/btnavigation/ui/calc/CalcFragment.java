package com.example.btnavigation.ui.calc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.example.btnavigation.R;
import com.example.btnavigation.databinding.FragmentCalcBinding;

public class CalcFragment extends Fragment {
    private FragmentCalcBinding binding;
    private TextView inp;
    private TextView outp;
    private StringBuilder stringBuilder;
    private String operator;
    private boolean clearInp;
    private boolean preCalculate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_calc, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inp = getView().findViewById(R.id.input);
        outp = getView().findViewById(R.id.output);
        stringBuilder = new StringBuilder();
        operator = "";
        clearInp = false;
        preCalculate = false;

        Button c = (Button) view.findViewById(R.id.C);
        c.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onClickC(v);
            }
        });

        Button del = (Button) view.findViewById(R.id.del);
        del.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onClickDel(v);
            }
        });

        Button equal = (Button) view.findViewById(R.id.equal);
        equal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onClickEqual(v);
            }
        });

        Button CE = (Button) view.findViewById(R.id.CE) ;
        CE.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onClickCE(v);
            }
        });


        View.OnClickListener addnumber =new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickNum(view);
            }
        };


        View.OnClickListener addsymbol=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickOperator(view);
            }
        };

        Button num0=(Button) view.findViewById(R.id.num0);
        num0.setOnClickListener(addnumber);
        Button num1=(Button) view.findViewById(R.id.num1);
        num1.setOnClickListener(addnumber);
        Button num2=(Button) view.findViewById(R.id.num2);
        num2.setOnClickListener(addnumber);
        Button num3=(Button) view.findViewById(R.id.num3);
        num3.setOnClickListener(addnumber);
        Button num4=(Button) view.findViewById(R.id.num4);
        num4.setOnClickListener(addnumber);
        Button num5=(Button) view.findViewById(R.id.num5);
        num5.setOnClickListener(addnumber);
        Button num6=(Button) view.findViewById(R.id.num6);
        num6.setOnClickListener(addnumber);
        Button num7=(Button) view.findViewById(R.id.num7);
        num7.setOnClickListener(addnumber);
        Button num8=(Button) view.findViewById(R.id.num8);
        num8.setOnClickListener(addnumber);
        Button num9=(Button) view.findViewById(R.id.num9);
        num9.setOnClickListener(addnumber);

        Button mul= (Button) view.findViewById(R.id.mul);
        mul.setOnClickListener(addsymbol);

        Button plus= (Button) view.findViewById(R.id.plus);
        plus.setOnClickListener(addsymbol);

        Button minus= (Button) view.findViewById(R.id.minus);
        minus.setOnClickListener(addsymbol);

        Button div= (Button) view.findViewById(R.id.div);
        div.setOnClickListener(addsymbol);

        Button change = (Button) view.findViewById(R.id.change) ;
        change.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onClickChange(v);
            }
        });

    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onClickDel(View view){
        if (stringBuilder.length() > 0 ) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            outp.setText(stringBuilder.toString());
        }
        if (stringBuilder.length() == 0) {
            stringBuilder = new StringBuilder("0");
            outp.setText(stringBuilder.toString());
        }
    }

    public void onClickC(View view) {
        stringBuilder = new StringBuilder();
        operator = "";
        clearInp = false;
        preCalculate = false;
        inp.setText("");
        outp.setText("0");
    }

    public void onClickCE(View view) {
        stringBuilder = new StringBuilder();
        outp.setText("0");
    }

    public static String removeLastCharacter(String str) {
        String result = null;
        if ((str != null) && (str.length() > 0)) {
            result = str.substring(0, str.length() - 1);
        }
        return result;
    }
    public void onClickChange(View view){
        String number = outp.getText().toString();

        if(number.charAt(0) != '-') {
            stringBuilder.insert(0, "-");
            outp.setText(stringBuilder.toString());
        }
        else {
            stringBuilder.delete(0,1);
            outp.setText(stringBuilder.toString());
        }
    }

    public void onClickEqual(View view) {
        int result = 0;
        if (operator.equals("+")) {
            result = Integer.parseInt(removeLastCharacter(inp.getText().toString())) + Integer.parseInt(outp.getText().toString());
        }
        if (operator.equals("-")) {
            result = Integer.parseInt(removeLastCharacter(inp.getText().toString())) - Integer.parseInt(outp.getText().toString());
        }
        if (operator.equals("×")) {
            result = Integer.parseInt(removeLastCharacter(inp.getText().toString())) * Integer.parseInt(outp.getText().toString());
        }
        if (operator.equals("÷")) {
            result = Integer.parseInt(removeLastCharacter(inp.getText().toString())) + Integer.parseInt(outp.getText().toString());
        }
        inp.append(stringBuilder.toString() + "=");
        outp.setText(Integer.toString(result));
        preCalculate = true;
    }

    public void onClickNum(View view) {
        if (!inp.getText().toString().isEmpty() && clearInp == true) {
            clearInp = false;
            stringBuilder = new StringBuilder();
        }
        if (inp.getText().toString().isEmpty() && preCalculate == true) {
            preCalculate = false;
            stringBuilder = new StringBuilder();
        }

        if (!inp.getText().toString().isEmpty() && preCalculate == true) {
            preCalculate = false;
            inp.setText("");
            stringBuilder = new StringBuilder();
        }
        stringBuilder.append(((Button)view).getText());
        outp.setText(stringBuilder.toString());
    }

    public void onClickOperator(View view) {
        if (inp.getText().toString().isEmpty()) {
            stringBuilder.append(((Button)view).getText());
            inp.setText(stringBuilder.toString());
            operator = ((Button)view).getText().toString();
            clearInp = true;
        } else {
            if (clearInp) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                stringBuilder.append(((Button)view).getText());
                inp.setText(stringBuilder.toString());
                operator = ((Button)view).getText().toString();
            } else {
                onClickEqual(view.findViewById(R.id.equal));
                stringBuilder.append(((Button)view).getText());
                inp.setText(stringBuilder.toString());
                operator = ((Button)view).getText().toString();
                clearInp = true;
            }
        }
    }
}
