package converter
import java.util.Scanner

val scanner = Scanner(System.`in`)

enum class Unit(val primary: Double, val plural: String, val secondary: Double = 0.0, val singular: String = "",var id: Int = -1){

    Gram(1.0, "grams"),Kilogram(1000.0, "kilograms"),Milligram(0.001, "milligrams"),
    Pound(453.592, "pounds"), Ounce(28.3495, "ounces"),
    Meter(1.0, "meters"), Kilometer(1000.0, "kilometers"), Centimeter(0.01, "centimeters"),
    Millimeter(0.001, "millimeters"), Mile(1609.39, "miles"), Yard(0.9144, "yards"),
    Foot(0.3048, "feet"), Inch(0.0254, "inches"),


    Fahrenheit(9.0/5.0, "degrees Fahrenheit", 32.0, "degree Fahrenheit"),
    Celsius(1.0,"degrees Celsius", 0.0, "degree Celsius"), Kelvin(1.0, "Kelvins", 273.15, "Kelvin")
}

fun input( choice: String){
    var unit: Double
    var system: String
    var aim: String
    var target: Unit = Unit.Gram
    var checkId: Int = -2
    var flag = 0

    choice.forEach { c -> flag = if(c.isDigit()) 1 else 0 }

    if(flag == 1){
        unit = choice.toDouble()
        system = scanner.next()
        system = system.toLowerCase()
        if(system == "degree" || system == "degrees"){
            system = scanner.next()
            system = system.toLowerCase()
        }
        scanner.next()
        aim = scanner.next()
        aim = aim.toLowerCase()
        if(aim == "degree" || aim == "degrees"){
            aim = scanner.next()
            aim = aim.toLowerCase()
        }

        when (aim) {
            "m", "meter", "meters" -> {
                target = Unit.Meter
                target.id = 1
            }
            "km", "kilometer", "kilometers" -> {
                target = Unit.Kilometer
                target.id = 1
            }
            "cm", "centimeter", "centimeters" -> {
                target = Unit.Centimeter
                target.id = 1
            }
            "mm", "millimeter",  "millimeters" -> {
                target = Unit.Millimeter
                target.id = 1
            }
            "mi", "mile", "miles" -> {
                target = Unit.Mile
                target.id = 1
            }
            "yd", "yard", "yards" -> {
                target = Unit.Yard
                target.id = 1
            }
            "ft", "foot", "feet" -> {
                target = Unit.Foot
                target.id = 1
            }
            "in", "inch", "inches" -> {
                target = Unit.Inch
                target.id = 1
            }
            "g", "gram", "grams" -> {
                target = Unit.Gram
                target.id = 2
            }
            "kg", "kilogram", "kilograms" -> {
                target = Unit.Kilogram
                target.id = 2
            }
            "mg", "milligram", "milligrams" -> {
                target = Unit.Milligram
                target.id = 2
            }
            "lb", "pound", "pounds" -> {
                target = Unit.Pound
                target.id = 2
            }
            "oz", "ounce", "ounces" -> {
                target = Unit.Ounce
                target.id = 2
            }
            "celsius" ,"dc", "c" -> {
                target = Unit.Celsius
                target.id = 3
            }
            "fahrenheit", "df", "f" -> {
                target = Unit.Fahrenheit
                target.id = 3
            }
            "kelvin", "kelvins", "k" -> {
                target = Unit.Kelvin
                target.id = 3
            }
            else -> aim = "???"
        }
        when(system) {
            "m", "meter", "meters","cm", "centimeter", "centimeters",
            "km", "kilometer", "Kilometer", "kilometers","mm", "millimeter",  "millimeters",
            "mi", "mile", "miles", "yd", "yard", "yards", "ft", "foot", "feet",
            "in", "inch", "inches" -> checkId = 1

            "g", "gram", "grams", "kg", "kilogram", "kilograms", "mg", "milligram",
            "milligrams", "lb", "pound", "pounds", "oz", "ounce", "ounces" -> checkId = 2

            "celsius" ,"dc", "c", "Kelvin","kelvin", "kelvins", "Kelvins",
            "k", "fahrenheit", "df", "f" -> checkId = 3

            else -> system = "???"
        }
        if(aim != "???" && system != "???" && target.id == checkId){
            when (system) {
                "m", "meter", "meters" -> meter(unit, target)
                "km", "kilometer", "kilometers" -> kilometer(unit, target)
                "cm", "centimeter", "centimeters" -> centimeter(unit, target)
                "mm", "millimeter",  "millimeters" -> millimeter(unit, target)
                "mi", "mile", "miles" -> mile(unit, target)
                "yd", "yard", "yards" -> yard(unit, target)
                "ft", "foot", "feet" -> foot(unit, target)
                "in", "inch", "inches" -> inch(unit, target)
                "g", "Grams", "gram", "grams" -> gram(unit, target)
                "kg", "kilogram", "kilograms" -> kilogram(unit, target)
                "mg", "milligram", "milligrams" -> milligram(unit, target)
                "lb", "pound", "pounds" -> pound(unit, target)
                "oz", "ounce", "ounces" -> ounce(unit, target)
                "celsius","dc", "c" -> celsius(unit, target)
                "fahrenheit", "df", "f" -> fahrenheit(unit, target)
                "kelvin", "kelvins", "k" -> kelvin(unit, target)
            }
        } else {
            if(aim != "???") {
                when (aim) {
                    "Celsius", "celsius" ,"dc", "c" -> aim = Unit.Celsius.plural
                    "fahrenheit", "df", "f" -> aim = Unit.Fahrenheit.plural
                    "kelvin", "kelvins", "k" -> aim = Unit.Kelvin.plural
                    "lb", "pound", "pounds" -> aim = "pounds"
                    "cm", "centimeter", "centimeters" -> aim = "centimeters"
                    "m", "meter", "meters" -> aim = "meters"
                    "km", "kilometer", "kilometers" -> aim = "kilometers"
                    "mm", "millimeter",  "millimeters" -> aim = "millimeters"
                    "mi", "mile", "miles" -> aim = "miles"
                    "yd", "yard", "yards" -> aim = "yards"
                    "ft", "foot", "feet" -> aim = "feet"
                    "in", "inch", "inches" -> aim = "inches"
                    "g", "gram", "grams" -> aim = "grams"
                    "kg", "kilogram", "kilograms" -> aim = "kilograms"
                    "mg", "milligram", "milligrams" -> aim = "milligrams"
                    "oz", "ounce", "ounces" -> aim = "ounces"
                }
            }
            if(system != "???") {
                when (system) {
                    "Celsius", "celsius" ,"dc", "c" -> system = Unit.Celsius.plural
                    "Fahrenheit", "fahrenheit", "df", "f" -> system = Unit.Fahrenheit.plural
                    "kelvin", "kelvins", "k" -> system = Unit.Kelvin.plural
                    "lb", "pound", "pounds" -> system = "pounds"
                    "cm", "centimeter", "centimeters" -> system = "centimeters"
                    "m", "meter", "meters" -> system = "meters"
                    "km", "kilometer", "kilometers" -> system = "kilometers"
                    "mm", "millimeter",  "millimeters" -> system = "millimeters"
                    "mi", "mile", "miles" -> system = "miles"
                    "yd", "yard", "yards" -> system = "yards"
                    "ft", "foot", "feet" -> system = "feet"
                    "in", "inch", "inches" -> system = "inches"
                    "g", "gram", "grams" -> system = "grams"
                    "kg", "kilogram", "kilograms" -> system = "kilograms"
                    "mg", "milligram", "milligrams" -> system = "milligrams"
                    "oz", "ounce", "ounces" -> system = "ounces"
                }
            }
            print("Conversion from $system to $aim is impossible")
        }
    } else {
        readLine()
        print("Parse error")
    }
}

fun kilogram(unit: Double, target: Unit) {

    if (unit < 0){
        println("Weight shouldn't be negative")
        return
    }

    val value = unit * 1000.0 / target.primary

    if(unit == 1.0){
        if(value == 1.0){
            print("${unit} kilogram is $value ${target.name.toLowerCase()} ")
        } else {
            print("${unit} kilogram is $value ${target.plural.toLowerCase()}")
        }
    } else {
        if(value == 1.0){
            print("${unit} kilograms is $value ${target.name.toLowerCase()}")
        } else {
            print("${unit} kilograms is $value ${target.plural}")
        }
    }
}

fun gram(unit: Double, target: Unit) {

    if (unit < 0){
        println("Weight shouldn't be negative")
        return
    }
    val value = unit * 1.0 / target.primary

    if(unit == 1.0){
        if(value == 1.0){
            print("${unit} gram is $value ${target.name.toLowerCase()} ")
        } else {
            print("${unit} gram is $value ${target.plural}")
        }
    } else {
        if(value == 1.0){
            print("${unit} grams is $value ${target.name.toLowerCase()}")
        } else {
            print("${unit} grams is $value ${target.plural}")
        }
    }
}

fun milligram(unit: Double, target: Unit) {

    if (unit < 0){
        println("Weight shouldn't be negative")
        return
    }

    val value = unit * 0.001 / target.primary

    if(unit == 1.0){
        if(value == 1.0){
            print("${unit} milligram is $value ${target.name.toLowerCase()} ")
        } else {
            print("${unit} milligram is $value ${target.plural}")
        }
    } else {
        if(value == 1.0){
            print("${unit} milligrams is $value ${target.name.toLowerCase()}")
        } else {
            print("${unit} milligrams is $value ${target.plural}")
        }
    }
}

fun pound(unit: Double, target: Unit) {

    if (unit < 0){
        println("Weight shouldn't be negative")
        return
    }

    val value = unit * 453.592 / target.primary

    if(unit == 1.0){
        if(value == 1.0){
            print("${unit} pound is $value ${target.name.toLowerCase()} ")
        } else {
            print("${unit} pound is $value ${target.plural}")
        }
    } else {
        if(value == 1.0){
            print("${unit} pounds is $value ${target.name.toLowerCase()}")
        } else {
            print("${unit} pounds is $value ${target.plural}")
        }
    }
}

fun ounce(unit: Double, target: Unit) {

    if (unit < 0){
        println("Weight shouldn't be negative")
        return
    }

    val value = unit * 28.3495 / target.primary

    if(unit == 1.0){
        if(value == 1.0){
            print("${unit} ounce is $value ${target.name.toLowerCase()} ")
        } else {
            print("${unit} ounce is $value ${target.plural}")
        }
    } else {
        if(value == 1.0){
            print("${unit} ounces is $value ${target.name.toLowerCase()}")
        } else {
            print("${unit} ounces is $value ${target.plural}")
        }
    }
}

fun meter(unit: Double, target: Unit) {

    if (unit < 0){
        println("Length shouldn't be negative")
        return
    }

    val value = unit * 1 / target.primary

    if(unit == 1.0){
        if(value == 1.0){
            print("${unit} meter is $value ${target.name.toLowerCase()} ")
        } else {
            print("${unit} meter is $value ${target.plural}")
        }
    } else {
        if(value == 1.0){
            print("${unit} meters is $value ${target.name.toLowerCase()}")
        } else {
            print("${unit} meters is $value ${target.plural}")
        }
    }
}

fun kilometer(unit: Double, target: Unit) {

    if (unit < 0){
        println("Length shouldn't be negative")
        return
    }

    val value = unit * 1000.0 / target.primary

    if(unit == 1.0){
        if(value == 1.0){
            print("${unit} kilometer is $value ${target.name.toLowerCase()} ")
        } else {
            print("${unit} kilometer is $value ${target.plural}")
        }
    } else {
        if(value == 1.0){
            print("${unit} kilometers is $value ${target.name.toLowerCase()}")
        } else {
            print("${unit} kilometers is $value ${target.plural}")
        }
    }
}

fun millimeter(unit: Double, target: Unit) {

    if (unit < 0){
        println("Length shouldn't be negative")
        return
    }

    val value = unit * 0.001 / target.primary

    if(unit == 1.0){
        if(value == 1.0){
            print("${unit} millimeter is $value ${target.name.toLowerCase()} ")
        } else {
            print("${unit} millimeter is $value ${target.plural}")
        }
    } else {
        if(value == 1.0){
            print("${unit} millimeters is $value ${target.name.toLowerCase()}")
        } else {
            print("${unit} millimeters is $value ${target.plural}")
        }
    }
}

fun centimeter(unit: Double, target: Unit) {

    if (unit < 0){
        println("Length shouldn't be negative")
        return
    }

    val value = unit * 0.01 / target.primary

    if(unit == 1.0){
        if(value == 1.0){
            print("${unit} centimeter is $value ${target.name.toLowerCase()} ")
        } else {
            print("${unit} centimeter is $value ${target.plural}")
        }
    } else {
        if(value == 1.0){
            print("${unit} centimeters is $value ${target.name.toLowerCase()}")
        } else {
            print("${unit} centimeters is $value ${target.plural}")
        }
    }
}

fun yard(unit: Double, target: Unit) {

    if (unit < 0){
        println("Length shouldn't be negative")
        return
    }

    val value = unit * 0.9144 / target.primary

    if(unit == 1.0){
        if(value == 1.0){
            print("${unit} yard is $value ${target.name.toLowerCase()} ")
        } else {
            print("${unit} yard is $value ${target.plural}")
        }
    } else {
        if(value == 1.0){
            print("${unit} yards is $value ${target.name.toLowerCase()}")
        } else {
            print("${unit} yards is $value ${target.plural}")
        }
    }
}

fun mile(unit: Double, target: Unit) {

    if (unit < 0){
        println("Length shouldn't be negative")
        return
    }

    val value = unit * 1609.39 / target.primary

    if(unit == 1.0){
        if(value == 1.0){
            print("${unit} mile is $value ${target.name.toLowerCase()} ")
        } else {
            print("${unit} mile is $value ${target.plural}")
        }
    } else {
        if(value == 1.0){
            print("${unit} miles is $value ${target.name.toLowerCase()}")
        } else {
            print("${unit} miles is $value ${target.plural}")
        }
    }
}

fun inch(unit: Double, target: Unit) {

    if (unit < 0){
        println("Length shouldn't be negative")
        return
    }

    val value = unit * 0.254 / target.primary

    if(unit == 1.0){
        if(value == 1.0){
            print("${unit} inch is $value ${target.name.toLowerCase()} ")
        } else {
            print("${unit} inch is $value ${target.plural}")
        }
    } else {
        if(value == 1.0){
            print("${unit} inches is $value ${target.name.toLowerCase()}")
        } else {
            print("${unit} inches is $value ${target.plural}")
        }
    }
}

fun foot(unit: Double, target: Unit) {

    if (unit < 0){
        println("Length shouldn't be negative")
        return
    }

    val value = unit * 0.3048 / target.primary

    if(unit == 1.0){
        if(value == 1.0){
            print("${unit} foot is $value ${target.name.toLowerCase()} ")
        } else {
            print("${unit} foot is $value ${target.plural}")
        }
    } else {
        if(value == 1.0){
            print("${unit} feet is $value ${target.name.toLowerCase()}")
        } else {
            print("${unit} feet is $value ${target.plural}")
        }
    }
}

fun fahrenheit(unit: Double, target: Unit) {

    val value = (unit - 32.0) * (5.0 / 9.0) * (target.primary) + target.secondary

    if(unit == 1.0){
        if(value == 1.0){
            print("${unit} degree Fahrenheit is $value ${target.singular} ")
        } else {
            print("${unit} degree Fahrenheit is $value ${target.plural}")
        }
    } else {
        if(value == 1.0){
            print("${unit} degrees Fahrenheit is $value ${target.singular}")
        } else {
            print("${unit} degrees Fahrenheit is $value ${target.plural}")
        }
    }
}

fun kelvin(unit: Double, target: Unit) {

    val value = (unit - 273.15) * target.primary + target.secondary

    if(unit == 1.0){
        if(value == 1.0){
            print("${unit} Kelvin is $value ${target.singular} ")
        } else {
            print("${unit} Kelvin is $value ${target.plural}")
        }
    } else {
        if(value == 1.0){
            print("${unit} Kelvins is $value ${target.singular}")
        } else {
            print("${unit} Kelvins is $value ${target.plural}")
        }
    }
}

fun celsius(unit: Double, target: Unit) {

    val value = unit*target.primary + target.secondary

    if(unit == 1.0){
        if(value == 1.0){
            print("${unit} degree Celsius is $value ${target.singular} ")
        } else {
            print("${unit} degree Celsius is $value ${target.plural}")
        }
    } else {
        if(value == 1.0){
            print("${unit} degrees Celsius is $value ${target.singular}")
        } else {
            print("${unit} degrees Celsius is $value ${target.plural}")
        }
    }
}
fun main() {
    var choice: String
    print("Enter what you want to convert (or exit): ")
    choice = scanner.next()

    while(choice != "exit") {
        input(choice)
        println()
        print("Enter what you want to convert (or exit): ")
        choice = scanner.next()
    }
}