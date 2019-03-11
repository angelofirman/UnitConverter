# UnitConverter

For supported temperature and volume unit, please refer to Constant.java. A few samples are: Constant.TEMP_CELCIUS, Constant.TEMP_KELVIN, Constant.VOL_GALLON, Constant.VOL_LITRE.

To introduce new units, please add the unit and conversion constants in Constant.java, put the new constant with the flag into Constant.UNIT_MAP, put the supported conversion into Constant.CONVERSION_MAP, and finally state the formula in UnitConverter.convertUnit function.
