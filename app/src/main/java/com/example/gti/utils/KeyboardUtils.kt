package com.example.gti.utils

import android.widget.Button
import com.example.gti.databinding.FragmentGasFeaturesBinding
import com.example.gti.databinding.KeyboardLayoutBinding

object KeyboardUtils {

        private val keyboardButtonsList = ArrayList<Button>()

        fun initKeyboardButtonsValues(keyboardBinding: KeyboardLayoutBinding) {
            (keyboardBinding.button11.keyboardButton).text = "1"
            (keyboardBinding.button12.keyboardButton).text = "2"
            (keyboardBinding.button13.keyboardButton).text = "3"

            (keyboardBinding.button21.keyboardButton).text = "4"
            (keyboardBinding.button22.keyboardButton).text = "5"
            (keyboardBinding.button23.keyboardButton).text = "6"

            (keyboardBinding.button31.keyboardButton).text = "7"
            (keyboardBinding.button32.keyboardButton).text = "8"
            (keyboardBinding.button33.keyboardButton).text = "9"

            (keyboardBinding.button41.keyboardButton).text = "."
            (keyboardBinding.button42.keyboardButton).text = "0"
            (keyboardBinding.button43.keyboardButton).text = "\u232b"
        }

        fun onMileageKeyboardButtonClicked(
            gasFeaturesBinding: FragmentGasFeaturesBinding,
            keyboardBinding: KeyboardLayoutBinding
        ) {
            val keyboardButtons = this.setKeyboardButtonsList(keyboardBinding)

            for (keyboardButton in keyboardButtons) {
                keyboardButton.setOnClickListener {
                    gasFeaturesBinding.leftTextView.text = prepareValueOnMileageKeyboardButtonClick(
                        gasFeaturesBinding.leftTextView.text.toString(),
                        keyboardButton.text.toString()
                    )
                }
            }
        }

        fun onFuelKeyboardButtonClicked(
            gasFeaturesBinding: FragmentGasFeaturesBinding,
            keyboardBinding: KeyboardLayoutBinding
        ) {
            val keyboardButtons = this.setKeyboardButtonsList(keyboardBinding)

            for (keyboardButton in keyboardButtons) {
                keyboardButton.setOnClickListener {
                    gasFeaturesBinding.middleTextView.text = prepareValueOnFuelKeyboardButtonClick(
                        gasFeaturesBinding.middleTextView.text.toString(),
                        keyboardButton.text.toString()
                    )
                }
            }
        }

        fun onPriceKeyboardButtonClicked(
            gasFeaturesBinding: FragmentGasFeaturesBinding,
            keyboardBinding: KeyboardLayoutBinding
        ) {
            val keyboardButtons = this.setKeyboardButtonsList(keyboardBinding)

            for (keyboardButton in keyboardButtons) {
                keyboardButton.setOnClickListener {
                    gasFeaturesBinding.rightTextView.text = prepareValueOnPriceKeyboardButtonClick(
                        gasFeaturesBinding.rightTextView.text.toString(),
                        keyboardButton.text.toString()
                    )
                }
            }
        }

        private fun setKeyboardButtonsList(keyboardBinding: KeyboardLayoutBinding): List<Button> {
            keyboardButtonsList.clear()

            keyboardButtonsList.add(keyboardBinding.button11.keyboardButton)
            keyboardButtonsList.add(keyboardBinding.button12.keyboardButton)
            keyboardButtonsList.add(keyboardBinding.button13.keyboardButton)

            keyboardButtonsList.add(keyboardBinding.button21.keyboardButton)
            keyboardButtonsList.add(keyboardBinding.button22.keyboardButton)
            keyboardButtonsList.add(keyboardBinding.button23.keyboardButton)

            keyboardButtonsList.add(keyboardBinding.button31.keyboardButton)
            keyboardButtonsList.add(keyboardBinding.button32.keyboardButton)
            keyboardButtonsList.add(keyboardBinding.button33.keyboardButton)

            keyboardButtonsList.add(keyboardBinding.button41.keyboardButton)
            keyboardButtonsList.add(keyboardBinding.button42.keyboardButton)
            keyboardButtonsList.add(keyboardBinding.button43.keyboardButton)

            return keyboardButtonsList
        }

        private fun prepareValueOnMileageKeyboardButtonClick(infoText: String, keyboardButtonText: String): String {
            if (((infoText.length == 5 && !infoText.contains(".")) || (infoText.length == 6 && infoText.contains("."))) && keyboardButtonText != "⌫") {
                return infoText
            }

            if (keyboardButtonText == "⌫") {
                if (infoText.length > 1) {
                    if (infoText.contains(".") && infoText != "0.0") {
                        if (infoText[infoText.length - 1].toString() == ".") {
                            return infoText.substring(0, infoText.length - 1)
                        } else {
                            return infoText.substring(0, infoText.length - 2)
                        }
                    } else if (infoText == "0.0") {
                        return infoText
                    } else {
                        return infoText.substring(0, infoText.length - 1)
                    }
                } else {
                    return "0.0"
                }
            }

            if (keyboardButtonText == ".") {
                if (infoText == "0.0") {
                    return "0.0"
                } else if (infoText.contains(".")) {
                    return infoText
                }
            }

            if (keyboardButtonText == "0") {
                if (infoText == "0.0") {
                    return "0"
                } else if (infoText == "0") {
                    return infoText
                }
            }

            if (infoText.contains(".") && infoText[infoText.length - 1].toString() != "." && infoText != "0.0") {
                return infoText
            } else if (infoText == "0.0") {
                return keyboardButtonText
            } else if (infoText == "0" && keyboardButtonText != ".") {
                return keyboardButtonText
            }else {
                return infoText + keyboardButtonText
            }
        }

        private fun prepareValueOnFuelKeyboardButtonClick(infoText: String, keyboardButtonText: String): String {
            if (((infoText.length == 3 && !infoText.contains(".") && keyboardButtonText != ".") || (infoText.length == 6 && infoText.contains("."))) && keyboardButtonText != "⌫") {
                return infoText
            }

            if (keyboardButtonText == "⌫") {
                if (infoText.length > 1) {
                    if (infoText.contains(".") && infoText != "0.0") {
                        if (infoText[infoText.length - 1].toString() == ".") {
                            return infoText.substring(0, infoText.length - 1)
                        }

                        val splittedInfoText = infoText.split(".")
                        if (splittedInfoText[1].length == 1) {
                            return infoText.substring(0, infoText.length - 2)
                        } else {
                            return infoText.substring(0, infoText.length - 3)
                        }
                    } else if (infoText == "0.0") {
                        return infoText
                    } else {
                        return infoText.substring(0, infoText.length - 1)
                    }
                } else {
                    return "0.0"
                }
            }

            if (keyboardButtonText == ".") {
                if (infoText == "0.0") {
                    return "0.0"
                } else if (infoText.contains(".")) {
                    return infoText
                }
            }

            if (keyboardButtonText == "0") {
                if (infoText == "0.0") {
                    return "0"
                } else if (infoText == "0") {
                    return infoText
                }
            }

            if (infoText.contains(".") && infoText[infoText.length - 1].toString() != "." && infoText[infoText.length - 2].toString() != "." && infoText != "0.0") {
                return infoText
            } else if (infoText == "0.0") {
                return keyboardButtonText
            } else if (infoText == "0" && keyboardButtonText != ".") {
                return keyboardButtonText
            } else {
                return infoText + keyboardButtonText
            }
        }

        private fun prepareValueOnPriceKeyboardButtonClick(infoText: String, keyboardButtonText: String): String {
            if (((infoText.length == 1 && !infoText.contains(".") && keyboardButtonText != ".") || (infoText.length == 4 && infoText.contains("."))) && keyboardButtonText != "⌫") {
                return infoText
            }

            if (keyboardButtonText == "⌫") {
                if (infoText.length > 1) {
                    if (infoText.contains(".") && infoText != "0.0") {
                        if (infoText[infoText.length - 1].toString() == ".") {
                            return infoText.substring(0, infoText.length - 1)
                        }

                        val splittedInfoText = infoText.split(".")
                        if (splittedInfoText[1].length == 1) {
                            return infoText.substring(0, infoText.length - 2)
                        } else {
                            return infoText.substring(0, infoText.length - 3)
                        }
                    } else if (infoText == "0.0") {
                        return infoText
                    } else {
                        return infoText.substring(0, infoText.length - 1)
                    }
                } else {
                    return "0.0"
                }
            }

            if (keyboardButtonText == ".") {
                if (infoText == "0.0") {
                    return "0.0"
                } else if (infoText.contains(".")) {
                    return infoText
                }
            }

            if (keyboardButtonText == "0") {
                if (infoText == "0.0") {
                    return "0"
                } else if (infoText == "0") {
                    return infoText
                }
            }

            if (infoText.contains(".") && infoText[infoText.length - 1].toString() != "." && infoText[infoText.length - 2].toString() != "." && infoText != "0.0") {
                return infoText
            } else if (infoText == "0.0") {
                return keyboardButtonText
            } else if (infoText == "0" && keyboardButtonText != ".") {
                return keyboardButtonText
            } else {
                return infoText + keyboardButtonText
            }
        }

}