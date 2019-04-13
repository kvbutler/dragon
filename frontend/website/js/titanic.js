/*global WildRydes _config*/

var WildRydes = window.WildRydes || {};
WildRydes.map = WildRydes.map || {};

(function rideScopeWrapper($) {
    var authToken;
    WildRydes.authToken.then(function setAuthToken(token) {
        if (token) {
            authToken = token;
        } else {
            window.location.href = '/signin.html';
        }
    }).catch(function handleTokenError(error) {
        alert(error);
        window.location.href = '/signin.html';
    });
    function requestResults(passengerGender, passengerClass) {
        $.ajax({
            method: 'POST',
            url: _config.api.invokeUrl + '/get_results',
            headers: { Authorization: authToken}, //, "Access-Control-Allow-Headers": "Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token"
            data: JSON.stringify({
                "gender": passengerGender,
                "passengerClass": passengerClass}
            ),
            contentType: 'application/json',
            success: completeRequest,
            error: function ajaxError(jqXHR, textStatus, errorThrown) {
                console.error('Error requesting results: ', textStatus, ', Details: ', errorThrown);
                console.error('Response: ', jqXHR.responseText);
                alert('An error occured when getting results:\n' + jqXHR.responseText);
            }
        });
    }

    function completeRequest(result) {
        console.log('Response received from API: ', result);
        resultMessage = result.passengerGender;
        alert('Passenger is ' + resultMessage + '.');
        //displayUpdate('Gender of passenger was ' + resultMessage);
    }

    // Register click handler for #request button
    $(function onDocReady() {
        $('#request').click(handleRequestClick);
        $('#signOut').click(function() {
            WildRydes.signOut();
            alert("You have been signed out.");
            window.location = "index.html";
        });
        $(WildRydes.map).on('pickupChange', handlePickupChanged);

        WildRydes.authToken.then(function updateAuthMessage(token) {
            if (token) {
                displayUpdate('You are authenticated. Click to see your <a href="#authTokenModal" data-toggle="modal">auth token</a>.');
                $('.authToken').text(token);
            }
        });

        if (!_config.api.invokeUrl) {
            $('#noApiMessage').show();
        }
    });

    function handlePickupChanged() {
        var requestButton = $('#request');
        requestButton.text('Request Unicorn');
        requestButton.prop('disabled', false);
    }

    function getValueFromForm(elementId) {
        var elt = document.getElementById(elementId);

        return elt.options[elt.selectedIndex].text;
    }

    function handleRequestClick(event) {
        // var passengerGender = getValueFromForm('gender');
        // var passengerClass = getValueFromForm('passengerClass');
        var passengerGender = 1;
        var passengerClass = 1;

        console.log("Passenger Gender: " + passengerGender);
        console.log("Passenger Class" + passengerClass);
        requestResults(passengerGender, passengerClass);
        //requestUnicorn(pickupLocation);
    }

    function animateArrival(callback) {
        var dest = WildRydes.map.selectedPoint;
        var origin = {};

        if (dest.latitude > WildRydes.map.center.latitude) {
            origin.latitude = WildRydes.map.extent.minLat;
        } else {
            origin.latitude = WildRydes.map.extent.maxLat;
        }

        if (dest.longitude > WildRydes.map.center.longitude) {
            origin.longitude = WildRydes.map.extent.minLng;
        } else {
            origin.longitude = WildRydes.map.extent.maxLng;
        }

        WildRydes.map.animate(origin, dest, callback);
    }

    function displayUpdate(text) {
        $('#updates').append($('<li>' + text + '</li>'));
    }
 }(jQuery));


 // Form validation and submission

//  (($) => {
//  function validateForm() {
//
//     let validateRequiredRadio = (groups) => {
//         let valid = true;
//         if (groups) {
//             groups.forEach(group => {
//                 valid = [...group].some(rb => rb.checked);
//             });
//         }
//         return valid;
//     }
//
//     let validateRequiredText = (inputs) => inputs.every(input => input.value);
//
//     let rbgPassengerClass = document.getElementsByName('rbgPassengerClass');
//     let rbgGender = document.getElementsByName('rbgGender');
//     let rbgPort = document.getElementsByName('rbgPort');
//
//     let txtAge = document.getElementById('txtAge');
//     let txtSiblingSpouses = document.getElementById('txtSiblingSpouses');
//     let txtParentsChildren = document.getElementById('txtParentsChildren');
//     let txtCost = document.getElementById('txtCost');
//     let slCabinLocation = document.getElementById('slCabinLocation');
//
//     let radiosValid = validateRequiredRadio([rbgPassengerClass,
//         rbgGender,
//         rbgPort]);
//
//     let textValid = validateRequiredText([txtAge,
//         txtSiblingSpouses,
//         txtParentsChildren,
//         txtCost,
//         slCabinLocation]);
//
//     return radiosValid && textValid;
// }
//
// $(() => {
//     $('#form').submit((e) => {
//         e.preventDefault();
//         if (validateForm()) {
//             alert('Stub');
//         } else {
//             alert('All form fields are required.')
//         }
//     });
// });
// })(jQuery);
