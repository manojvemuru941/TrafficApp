package com.trafficapp

import com.trafficapp.models.TrafficCamera
import com.trafficapp.models.TrafficData

object Testdata {
    val sampleResponseData: ArrayList<TrafficData>
        get() {
            return arrayListOf(
                TrafficData(
                    quadrant = "SE",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc29.jpg",
                        description = "Camera 30"
                    ),
                    cameraLocation = "114 Avenue / 52 Street SE"
                ),
                TrafficData(
                    quadrant = "NW/NE",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc89.jpg",
                        description = "Camera 90"
                    ),
                    cameraLocation = "Samis Road / Centre Street North"
                ),
                TrafficData(
                    quadrant = "NW",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc78.jpg",
                        description = "Camera 79"
                    ),
                    cameraLocation = "Charleswood Dr / John Laurie Bv NW"
                ),
                TrafficData(
                    quadrant = "NE",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc34.jpg",
                        description = "Camera 35"
                    ),
                    cameraLocation = "Airport Trail / 36 Street NE"
                ),
                TrafficData(
                    quadrant = "NE",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc36.jpg",
                        description = "Camera 37"
                    ),
                    cameraLocation = "16 Avenue / Deerfoot Trail NE"
                ),
                TrafficData(
                    quadrant = "SW",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc15.jpg",
                        description = "Camera 16"
                    ),
                    cameraLocation = "Glenmore Trail / Crowchild Trail SW"
                ),
                TrafficData(
                    quadrant = "SE",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc19.jpg",
                        description = "Camera 20"
                    ),
                    cameraLocation = "22 Avenue / Deerfoot Trail SE"
                ),
                TrafficData(
                    quadrant = "SE",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc109.jpg",
                        description = "Camera 110"
                    ),
                    cameraLocation = "Barlow Trail / Deerfoot Trail SE"
                ),
                TrafficData(
                    quadrant = "NW",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc135.jpg",
                        description = "Camera 136"
                    ),
                    cameraLocation = "Stoney Trail / Country Hills Blvd NW"
                ),
                TrafficData(
                    quadrant = "NE",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc70.jpg",
                        description = "Camera 71"
                    ),
                    cameraLocation = "16 Avenue / 19 Street NE"
                ),
                TrafficData(
                    quadrant = "SE",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc46.jpg",
                        description = "Camera 47"
                    ),
                    cameraLocation = "25 Avenue / Spiller Road SE"
                ),
                TrafficData(
                    quadrant = "NW",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc72.jpg",
                        description = "Camera 73"
                    ),
                    cameraLocation = "Stoney Trail / Sarcee Trail NW"
                )
            )
        }

    val sortedData: ArrayList<TrafficData>
        get() {
            return arrayListOf(
                TrafficData(
                    quadrant = "NW",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc78.jpg",
                        description = "Camera 79"
                    ),
                    cameraLocation = "Charleswood Dr / John Laurie Bv NW"
                ),
                TrafficData(
                    quadrant = "NW",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc135.jpg",
                        description = "Camera 136"
                    ),
                    cameraLocation = "Stoney Trail / Country Hills Blvd NW"
                ),
                TrafficData(
                    quadrant = "NW",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc72.jpg",
                        description = "Camera 73"
                    ),
                    cameraLocation = "Stoney Trail / Sarcee Trail NW"
                ),
                TrafficData(
                    quadrant = "NE",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc70.jpg",
                        description = "Camera 71"
                    ),
                    cameraLocation = "16 Avenue / 19 Street NE"
                ),
                TrafficData(
                    quadrant = "NE",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc36.jpg",
                        description = "Camera 37"
                    ),
                    cameraLocation = "16 Avenue / Deerfoot Trail NE"
                ),
                TrafficData(
                    quadrant = "NE",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc34.jpg",
                        description = "Camera 35"
                    ),
                    cameraLocation = "Airport Trail / 36 Street NE"
                ),
                TrafficData(
                    quadrant = "SW",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc15.jpg",
                        description = "Camera 16"
                    ),
                    cameraLocation = "Glenmore Trail / Crowchild Trail SW"
                ),
                TrafficData(
                    quadrant = "SE",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc29.jpg",
                        description = "Camera 30"
                    ),
                    cameraLocation = "114 Avenue / 52 Street SE"
                ),
                TrafficData(
                    quadrant = "SE",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc19.jpg",
                        description = "Camera 20"
                    ),
                    cameraLocation = "22 Avenue / Deerfoot Trail SE"
                ),
                TrafficData(
                    quadrant = "SE",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc46.jpg",
                        description = "Camera 47"
                    ),
                    cameraLocation = "25 Avenue / Spiller Road SE"
                ),
                TrafficData(
                    quadrant = "SE",
                    trafficCamera = TrafficCamera(
                        url = "http://trafficcam.calgary.ca/loc109.jpg",
                        description = "Camera 110"
                    ),
                    cameraLocation = "Barlow Trail / Deerfoot Trail SE"
                )
            )
        }
}