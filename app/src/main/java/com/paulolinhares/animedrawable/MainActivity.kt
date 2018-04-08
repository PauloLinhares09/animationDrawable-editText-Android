package com.paulolinhares.animedrawable

import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var animationCurrent : AnimationDrawable
    lateinit var before : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        etField.addTextChangedListener(object : TextWatcher{


            override fun afterTextChanged(p0: Editable?) {
                Log.i("TAG", "init: " + p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.i("TAG", "before: " + p0.toString())
                before = p0.toString()


            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.i("TAG", "changed: " + p0.toString())

                if(p0!!.length == 1 && before.length < p0.length) {
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.anim_step1))
                    animationDrawable()
                }
                if (p0.length == 0 && before.length > p0.length) {
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.anim_step1_reverse))
                    animationDrawable()
                }
                if (p0.length == 5 && before.length < p0.length){
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.anim_step2))
                    animationDrawable()
                }
                if (p0.length == 5 && before.length > p0.length){
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.anim_step2_reverse))
                    animationDrawable()
                }

                //continue
            }

        })

    }

    private fun animationDrawable() {
        animationCurrent = imageView.drawable as AnimationDrawable
        animationCurrent.isOneShot = true
        animationCurrent.start()
    }


}
