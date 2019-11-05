$(document).ready(function () {

    let customValidationListener = function(event) {
        let valForm = document.getElementById("validated-form");
        if (valForm.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
        }
        valForm.classList.add('was-validated');
    };

    let browserValidation = () => {
        $("#validated-form-title").text("Browser validation");
        let valForm = document.getElementById("validated-form");
        valForm.reset();
        valForm.removeEventListener('submit', customValidationListener);
        valForm.noValidate = false;
        valForm.classList.remove('was-validated');

    }

    let customValidation = () => {
        $("#validated-form-title").text("Custom validation");
         let valForm = document.getElementById("validated-form");
         valForm.reset();
         valForm.removeEventListener('submit', customValidationListener);
         valForm.noValidate = true;
         valForm.addEventListener('submit', customValidationListener, false);
    }


     document.getElementById("browser-validation-radio").checked = true;

     browserValidation();

    $("#browser-validation-radio").on('change', function() {
        if ($(this).is(':checked')) {
            browserValidation();
        }
    });
    $("#client-validation-radio").on('change', function() {
        if ($(this).is(':checked')) {
            customValidation();
        }
    });

    $("#validated-form-name-field").change(function() {
        $("#name-valid-feedback").text("Hi, " + $("#validated-form-name-field").val() + "!");
    });
});
