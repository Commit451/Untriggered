# Untriggered

[![Build Status](https://travis-ci.org/Commit451/Untriggered.svg?branch=master)](https://travis-ci.org/Commit451/Untriggered) [![](https://jitpack.io/v/Commit451/Untriggered.svg)](https://jitpack.io/#Commit451/Untriggered)

![Triggered](http://i.imgur.com/rTWDmuc.gif "Triggered")

Sometimes, you just want to set the state of a `CompoundButton` such as a `CheckBox` or `Switch`, such as when these items are in a `RecyclerView`. You also want to listen for when these buttons change their "checked" state. But alas, when you bind the `ViewHolder` with the checked state, you get a `OnCheckedChangeListener` callback! The agony! `UntriggeredCheckBox` and the like allow you to set this checked state without triggering the listener. Wow!

# Usage
```java
final UntriggeredCheckBox checkBox = (UntriggeredCheckBox) findViewById(R.id.checkbox);

checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Snackbar.make(root, "Checkbox set to " + isChecked + " and I am triggered!", Snackbar.LENGTH_SHORT)
                .show();
    }
});
findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //checkbox will be set, no one will be triggered. All is well
        checkBox.setCheckedUntriggered(!checkBox.isChecked());
    }
});
```

# Support
Please note that this library has a dependency on `appcompat`. Widgets are subclassed from their AppCompat counterparts, such as `AppCompatCheckBox` and the like to allow for fancy Material styling on all API levels.

Currently supported `CompoundButton`s are:
- CheckBox
- RadioButton
- Switch (SwitchCompat)
- ToggleButton

And some others:
- SeekBar
- RatingBar
- Spinner

Feel free to make a PR if you feel another widget should be added! They are very simple to make.

License
--------

    Copyright 2016 Commit 451

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
