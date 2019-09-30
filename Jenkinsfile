/**
 * Jenkins Pipeline Definition
 */

node {
	timestamps {

		timeout(time: 30, unit: 'MINUTES') {
			checkout scm

			def artifactName = "transactionDataExporter"
			def projectLocation = "com/amadeus/sentinel/batch/${artifactName}"

			def dockerImage
			def version = "latest"
			def server = Artifactory.newServer url: ARTIFACTORY_URL, credentialsId: 'JFROG_LOCAL'

			def tool = docker.image('docker.io/nishanth90/maven-docker:latest')
			tool.pull()

			tool.inside("--net=host -u root -v /var/run/docker.sock:/var/run/docker.sock") {

			stage("Build") {
					sh 'mvn clean install'
				}

				stage('Artifactory upload') {

					println 'Upload artifacts to local-jfrog'
					withCredentials([usernamePassword( credentialsId: 'JFROG_LOCAL', usernameVariable: 'AR_USERNAME', passwordVariable: 'AR_PASSWORD')])  { sh 'mvn -B -Denv.AR_USER=$AR_USERNAME -Denv.AR_PASSWORD=$AR_PASSWORD deploy' }
				}

				stage('artifacts') {
					archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
				}

			}
		}
	}
}
