package com.example.differentuitest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mazenrashed.printooth.Printooth;
import com.mazenrashed.printooth.data.printable.Printable;
import com.mazenrashed.printooth.data.printable.RawPrintable;
import com.mazenrashed.printooth.data.printable.TextPrintable;
import com.mazenrashed.printooth.data.printer.DefaultPrinter;
import com.mazenrashed.printooth.ui.ScanningActivity;
import com.mazenrashed.printooth.utilities.Printing;
import com.mazenrashed.printooth.utilities.PrintingCallback;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Set;

public class PosPrintActivity extends AppCompatActivity implements PrintingCallback {

    Printing printing;
    Button btnPairUnpair, btnPrint, mPairedBtn;
    TextView mPairedTv;

    BluetoothAdapter mBlueAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pos_print);

        //adapter
        mBlueAdapter = BluetoothAdapter.getDefaultAdapter();


        initView();
    }

    private void initView() {
        btnPairUnpair = findViewById(R.id.btn_pair_unpair);
        btnPrint = findViewById(R.id.btn_print);
        mPairedBtn = findViewById(R.id.btn_paired);
        mPairedTv =  findViewById(R.id.pairedTv);

        if(printing != null)
            printing.setPrintingCallback(this);

        btnPairUnpair.setOnClickListener(view -> {

            if(Printooth.INSTANCE.hasPairedPrinter())
                Printooth.INSTANCE.removeCurrentPrinter();
            else
            {
                startActivityForResult(new Intent(PosPrintActivity.this, ScanningActivity.class),ScanningActivity.SCANNING_FOR_PRINTER);
                changePairAndUnpair();
            }
        });

        btnPrint.setOnClickListener(view -> {

            if(!Printooth.INSTANCE.hasPairedPrinter())
                startActivityForResult(new Intent(PosPrintActivity.this, ScanningActivity.class),ScanningActivity.SCANNING_FOR_PRINTER);
            else
                printText();

        });

        //get paired devices btn click
        mPairedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBlueAdapter.isEnabled()){
                    mPairedTv.setText("Paired Devices");
                    Set<BluetoothDevice> devices = mBlueAdapter.getBondedDevices();
                    for (BluetoothDevice device: devices){
                        mPairedTv.append("\nDevice: " + device.getName()+ ", " + device);
                    }
                }
                else {
                    //bluetooth is off so can't get paired devices
                    //showToast("Turn on bluetooth to get paired devices");
                    Toast.makeText(PosPrintActivity.this, "Turn on bluetooth to get paired devices", Toast.LENGTH_SHORT).show();
                }
            }
        });

        changePairAndUnpair();

    }

    private void printText() {
        ArrayList<Printable> printables = new ArrayList<>();
        printables.add(new RawPrintable.Builder(new byte[]{27,100,4}).build());

        //add text
        printables.add(new TextPrintable.Builder()
        .setText("Hello World: From LOTTO")
        .setCharacterCode(DefaultPrinter.Companion.getCHARCODE_PC1252())
        .setNewLinesAfter(1)
        .build());

        //custom Text
        printables.add(new TextPrintable.Builder()
                .setText("Hello World")
                .setLineSpacing(DefaultPrinter.Companion.getLINE_SPACING_60())
                .setAlignment(DefaultPrinter.Companion.getALIGNMENT_CENTER())
                .setEmphasizedMode(DefaultPrinter.Companion.getEMPHASIZED_MODE_BOLD())
                .setUnderlined(DefaultPrinter.Companion.getUNDERLINED_MODE_ON())
                .setNewLinesAfter(1)
                .build());

        printing.print(printables);

    }

    private void changePairAndUnpair() {
        if(Printooth.INSTANCE.hasPairedPrinter())
            btnPairUnpair.setText(new StringBuilder("UnPair")
                    .append(Printooth.INSTANCE.getPairedPrinter().getName()).toString());
        else
            btnPairUnpair.setText("Pair with Printer");
    }

    @Override
    public void connectingWithPrinter() {
        Toast.makeText(this, "Connecting to Printer", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectionFailed(@NotNull String s) {
        Toast.makeText(this, "Failed: "+s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(@NotNull String s) {
        Toast.makeText(this, "Error: "+s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMessage(@NotNull String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void printingOrderSentSuccessfully() {
        Toast.makeText(this, "Order sent to Printer", Toast.LENGTH_SHORT).show();
    }

    //ctrl+o
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ScanningActivity.SCANNING_FOR_PRINTER && resultCode == Activity.RESULT_OK)
            initPrinting();
        changePairAndUnpair();
    }

    private void initPrinting() {
        if(!Printooth.INSTANCE.hasPairedPrinter())
            printing = Printooth.INSTANCE.printer();
        if(printing != null)
            printing.setPrintingCallback(this);
    }
}