/**
 * Jenkins Pipeline Definition
 */

node {
	timestamps {

		timeout(time: 30, unit: 'MINUTES') {
			checkout scm

			def artifactName = "transactionDataExporter"
			def projectLocation = "com/transaction/exporter/${artifactName}"

			def dockerImage
			def version = "latest"
			def server = Artifactory.newServer url: ARTIFACTORY_URL, credentialsId: 'CLOUD_CTORAGE_SERVICE_ACCOUNT'

			def tool = docker.image('docker.io/nishanth90/maven:latest')
			tool.pull()

			tool.inside("--net=host -u root -v /var/run/docker.sock:/var/run/docker.sock") {

			stage("Build") {
					sh 'mvn clean install'
				}

				stage('Artifactory upload') {

					println 'Upload artifacts to local-jfrog'
					withCredentials([ credentialsId: 'JFROG_LOCAL'])  { sh 'mvn deploy -Dmaven.test.skip=true' }
				}

				stage('artifacts') {
					archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
				}

			}
		}
	}
}
