'use strict';

function SpeakerListCtrl($scope, $http) {

    $scope.speaker = { 'name': 'Bob', 'shortBio': 'Java Developer' };

    //var url = 'https://uberconf.com/s/speakers.json';
    var url = '/script/speakers.json';

    $http.get(url)
         .success(function(data) {
            $scope.speakers = data;
         })
         .error(function(resp, status) {
            $scope.message = 'error: ' + status;
         });

}

function SpeakerViewCtrl($scope, $routeParams, $http) {

    var speakerId = $routeParams['id'];

        //console.debug('speaker: ' + speakerId);

        var findSpeaker = function(speakers) {

            var speaker;

            $.each(speakers, function(i,spk) {
                //console.debug('speaker: ' + speaker.name);
                if(spk.id == speakerId)
                    speaker = spk;
            });
            return speaker;
        };

        var url = '/script/speakers.json';
        $http.get(url)
             .success(function(data) {
                $scope.speaker = findSpeaker(data);
             })
             .error(function(resp, status) {
                $scope.message = 'error: ' + status;
             });



    $scope.updateSpeaker = function(speaker) {

        $scope.message = "Updated Speaker " + speaker.name;

/*
        speaker.$save(function(data) {
            $scope.message = 'Speaker Updated';
        },function(resp) {
            $scope.message = resp.message;
        });
*/


    };


}