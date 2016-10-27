
    //Var
    var groupBy = 'paymentFile';

    var apiUrl = "http://zsqbkee7tah5mmf4a-mock.stoplight-proxy.io/slx-api/v1 ";
   
    // add a footer row to the grid
    $scope.initGrid = function (s, e) {

        // create a GroupRow to show aggregates automatically
        var row = new wijmo.grid.GroupRow();

        // add the new GroupRow to the grid's 'columnFooters' panel
        s.columnFooters.rows.push(row);

        // add a sigma to the header to show that this is a summary row
        //s.bottomLeftCells.setCellData(0,0, '\u03A3');
    }

    // add a group by parameter to de Grid
    $scope.groupBy = function (groupBy) {    
        var groupDesc = new wijmo.collections.PropertyGroupDescription(groupBy);
        $scope.data.groupDescriptions.push(groupDesc);
        }



    //On Form Load
     inject([ '$scope', '$http', function($scope, $http) {
    camForm.on('form-loaded', function() {
    // tell the form SDK to fetch the variable named 'invoiceData'
         camForm.variableManager.fetchVariable('state');
    });
     }]);


  //On Variables Fetched
  inject([ '$scope', '$http', '$filter', function($scope, $http , $filter) {
    camForm.on('variables-fetched', function() {
      // work with the variable (bind it to the current AngularJS $scope)
        $scope.state = camForm.variableManager.variableValue('state');
    //set 
    $scope.approved=false;
    //Request retrieve by the API - To Do
    //var premiumRequestId = $scope.request ;
      var premiumRequestId = 2; 
         

        // Get Premium Request from the api , and populate the grid
      $scope.getPremiumRequest = function(id) {  
              //Get Method
              $http.get(apiUrl+"/premium-requests/"+id).then(function(result) {
                console.log(result.data);
                $scope.premiumRequest=result.data;
                $scope.data = new wijmo.collections.CollectionView($scope.getData(result.data));
              //$scope.data = [];
              //$scope.getData(result.data);
                //$scope.groupBy(groupBy);
              $scope.data.refresh();
                
              
            }, function errorCallback(response) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
                console.log("error");
          });
            
        } 
      // Get Premium Request from the api , and populate the grid
        $scope.getPolicies = function(id) {  
              //Get Method
              $scope.data=[]
              $http.get(apiUrl+"/policies/"+id).then(function(result) {
                console.log(result.data);
                $scope.policies=result.data;
                var batches = {"paymentFile": 1 ,
                      "insured":   " " , 
                      "carrier":"carrier", 
                      "policy": "",  
                      "dueDate":  new Date() , 
                      "premiumAmount": 0 ,
                      "disbursementType": "" , 
                      "anticipatedPayment":  new Date(),
                      "owner":   "" };
              $scope.data.push($.extend({}, $scope.header, batches));
              console.log($scope.data);
                
                
              
            }, function errorCallback(response) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
                console.log("error");
          });
            
        }

            // get data to the Grid ,
            $scope.getData = function(premiumRequest) {
                var data=[];
                $scope.header = {"client": premiumRequest.clientGroup.name ,
                 "group": premiumRequest.clientGroup.groupType ,
        
                  };
        
            //get Batches data, and construct an json Array
            angular.forEach(premiumRequest.batches, function(batch) {
              angular.forEach(batch.policies ,  function(p) {
          
                  $scope.getPolicies(p.policyId );
          

                
                    });           
                });
              return data;
            }

      $scope.getPremiumRequest(premiumRequestId);        
    });
    }]);

    //Before Submit
       camForm.on('submit', function(evt) {
        // this callback is executed when the form is submitted, *before* the submit request to
        // the server is executed
        // creating a new variable will add it to the form submit

        $scope.state.approved   = $scope.approved;
        

      })