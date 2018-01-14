package ug.edu.doctorsupporter;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class NotepadActivity extends AppCompatActivity {

    String textFromDatabase = ""; // Tutaj ma być pobieranie stringa z odpowiedniego miejsca w bazie danych

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);
        TextView notepad = findViewById(R.id.notepad);
        notepad.setText(textFromDatabase);
    }

    // Jeśli użytkownik próbuje wyjść bez zapisania zmian to aplikacja go o tym poinformuje tą metodą
    @Override
    public void onBackPressed() {
        TextView notepad = findViewById(R.id.notepad);
        String actualText = notepad.getText().toString();
        if (!actualText.equals(textFromDatabase)) {
            new AlertDialog.Builder(this)
                    .setTitle("Zmiany nie zostały zapisane!")
                    .setMessage("Czy chcesz zamknąć notatnik bez zapisywania zmian?")
                    .setNegativeButton(android.R.string.no, null)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface arg0, int arg1) {
                            NotepadActivity.super.onBackPressed();
                        }
                    }).create().show();
        } else {
            NotepadActivity.super.onBackPressed();
        }
    }

    //Zapisanie pliku w bazie danych
    public void saveToDatabase(View view) {
        TextView notepad = findViewById(R.id.notepad);
        String textToSave = notepad.getText().toString();
        /* I tu trzeba wysłać Stringa "textToSave" do odpowiedniego miejsca w bazie danych
        Jeśli się uda to sentCorrectly ma przyjmować wartość true:*/
        boolean sentCorrectly = false; // Na razie przycisk nie obsługuje bazy danych, więc z góry ma wartość "false"

        if (sentCorrectly) {
            textFromDatabase = textToSave;
        } else {
            Toast.makeText(this, "Zapisywanie zakończone niepowodzeniem, spróbuj ponownie!", Toast.LENGTH_SHORT).show();
        }
    }
}
