package ci.slyest.the.marvel.verse.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ci.slyest.the.marvel.verse.presentation.R
import ci.slyest.the.marvel.verse.presentation.viewmodels.CharacterViewModel
import org.koin.android.viewmodel.ext.android.viewModel

private const val ARG_ID = "characterId"

class CharacterActivity : AppCompatActivity() {

    private val mViewModel by viewModel<CharacterViewModel>()

    private var characterId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
        savedInstanceState?.let {
            characterId = it.getInt(ARG_ID)
        }
    }
}